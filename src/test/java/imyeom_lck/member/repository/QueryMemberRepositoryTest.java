package imyeom_lck.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import imyeom_lck.config.QuerydslTestConfig;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.dummy.DummyMember;
import imyeom_lck.member.dummy.dummyPointUsage;
import imyeom_lck.member.persistence.querydsl.inter.QueryMemberRepository;
import imyeom_lck.member.persistence.querydsl.impl.QueryMemberRepositoryImpl;
import imyeom_lck.pointusage.domain.entity.PointUsage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(QuerydslTestConfig.class)
public class QueryMemberRepositoryTest {


    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    private QueryMemberRepository queryMemberRepository;
    @PersistenceContext
    private EntityManager entityManager;

    private Member member1;
    private Member member2;
    private PointUsage pointUsage1;
    private PointUsage pointUsage2;

    @BeforeEach
    public void setUp() {

        member1 = DummyMember.createDummyMember("mem1", "password1", "phonenum1", "loginId1");
        member2 = DummyMember.createDummyMember("mem2", "password2", "phonenum2", "loginId2");

        pointUsage1 = dummyPointUsage.createPointUsage(1L, member1, LocalDateTime.of(2020, 4, 1, 0, 0), "History1");
        pointUsage2 = dummyPointUsage.createPointUsage(2L, member2, LocalDateTime.of(2020, 4, 2, 0, 0), "History2");

        queryMemberRepository = new QueryMemberRepositoryImpl(jpaQueryFactory);
    }

    @DisplayName("모든 멤버 찾기")
    @Test
    public void getAllMember() {

        // given
        entityManager.persist(member1);
        entityManager.persist(member2);

        // when
        List<Member> memberList = queryMemberRepository.queryDSLFindAll();

        assertEquals("mem2", memberList.get(1).getName());
        assertEquals("password2", memberList.get(1).getPassword());
        assertEquals("phonenum2", memberList.get(1).getPhoneNumber());
        assertEquals("loginId2", memberList.get(1).getLoginId());
        assertEquals("mem1", memberList.get(0).getName());
        assertEquals("password1", memberList.get(0).getPassword());
        assertEquals("phonenum1", memberList.get(0).getPhoneNumber());
        assertEquals("loginId1", memberList.get(0).getLoginId());

    }

    @DisplayName("memberId로 멤버 찾기")
    @Test
    public void getOneMember() {
        // given
        entityManager.persist(member1);
        entityManager.persist(member2);

        // when
        Member returnMember = queryMemberRepository.queryDSLFindByMemberId(member1.getMemberId()).orElseThrow();

        assertEquals("mem1", returnMember.getName());
        assertEquals("password1", returnMember.getPassword());
        assertEquals("phonenum1", returnMember.getPhoneNumber());
        assertEquals("loginId1", returnMember.getLoginId());

    }

    @DisplayName("memberId로 사용내역조회")
    @Test
    public void getPU(){
        // given
        entityManager.persist(member1);
        entityManager.persist(member2);
        entityManager.persist(pointUsage1);
        entityManager.persist(pointUsage2);

        List<PointUsage> puList = queryMemberRepository.queryDSLFindAllPUByMemberId(member1.getMemberId());

        assertEquals("History1", puList.get(0).getPointHistory());
        assertEquals(member1.getMemberId(), puList.get(0).getMember().getMemberId());

    }

}
