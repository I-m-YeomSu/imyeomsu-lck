package imyeom_lck.member.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import imyeom_lck.config.QuerydslTestConfig;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.dummy.DummyMember;
import imyeom_lck.member.dummy.dummyPointUsage;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.member.persistence.querydsl.QueryMemberRepository;
import imyeom_lck.member.persistence.querydsl.QueryMemberRepositoryImpl;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import imyeom_lck.member.service.impl.QueryMemberServiceImpl;
import imyeom_lck.pointusage.domain.entity.PointUsage;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QueryMemberServiceTest {
    @InjectMocks
    private QueryMemberServiceImpl queryMemberService;

    @Mock
    private QueryMemberRepository queryMemberRepository;

    private Member member1;
    private Member member2;
    private PointUsage pointUsage1;
    private PointUsage pointUsage2;

    private MemberDetailsResponseDTO memberDetailsResponseDTO;
    private List<Member> memberList;
    private List<PointUsage> puList;

    @BeforeEach
    void setUp() {
        member1 = DummyMember.createDummyMember("mem1", "password1", "phonenum1", "loginId1");
        member2 = DummyMember.createDummyMember("mem2", "password2", "phonenum2", "loginId2");

        pointUsage1 = dummyPointUsage.createPointUsage(1L, member1, LocalDateTime.of(2020, 4, 1, 0, 0), "History1");
        pointUsage2 = dummyPointUsage.createPointUsage(2L, member2, LocalDateTime.of(2020, 4, 2, 0, 0), "History2");


        memberDetailsResponseDTO = MemberDetailsResponseDTO.fromEntity(member1);

        memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);

        puList = new ArrayList<>();
        puList.add(pointUsage1);
        puList.add(pointUsage2);
    }

    @Test
    void getAll() {
        // given
        when(queryMemberRepository.queryDSLFindAll()).thenReturn(memberList);

        // when
        List<MemberDetailsResponseDTO> returnList = queryMemberService.findall();

        // then
        assertEquals(memberList.get(0).getName(), returnList.get(0).getMemberName());

    }

    @Test
    void getOne() throws InstantiationException, IllegalAccessException {

        Optional<Member> member = queryMemberRepository.queryDSLFindByMemberId(member1.getMemberId());

        // given
        when(queryMemberRepository.queryDSLFindByMemberId(member1.getMemberId())).thenReturn(Optional.ofNullable(member1));

        // when
        MemberDetailsResponseDTO returnMember = queryMemberService.findById(member1.getMemberId());

        // then
        assertEquals(member1.getLoginId(),returnMember.getLoginId());
        assertEquals(member1.getPassword(), returnMember.getMemberPassword());

    }

    @Test
    void getPU() {
        // given
        when(queryMemberRepository.queryDSLFindAllPUByMemberId(member1.getMemberId())).thenReturn(puList);

        // when
        List<PointUsage> returnPUList = queryMemberService.queryDSLFindAllPUByMemberId(member1.getMemberId());

        // then
        assertEquals(pointUsage1.getPointHistory(), returnPUList.get(0).getPointHistory());
    }

}

