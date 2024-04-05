package imyeom_lck.member.repository;

import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.domain.entity.SignUpRequest;
import imyeom_lck.member.dummy.DummyMember;
import imyeom_lck.member.dummy.DummySignUpRequest;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.member.persistence.jpa.JpaSignUpRequestRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JpaMemberRepository memberRepository;

    @Autowired
    private JpaSignUpRequestRepository signUpRequestRepository;

    private Member member1;
    private Member member2;
    private SignUpRequest signUpRequest1;

    @BeforeEach
    public void setUp(){
        member1 = DummyMember.createDummyMember("mem1", "password1" , "phonenum1", "loginId1");
        member2 = DummyMember.createDummyMember("mem2", "password2", "phonenum2", "loginId2");
        signUpRequest1 = DummySignUpRequest.createDummyUser("mem2", "password2", "phonenum2", "loginId2");
    }


    @DisplayName("회원Id로 회원 정보 조회 - 회원이 존재하는 경우")
    @Test
    public void testGetMemberDetails_Success() {
        // given
        entityManager.persist(member1);

        // when
        Member foundMember = memberRepository.findById(member1.getMemberId()).orElse(null);

        assertEquals("mem1", foundMember.getName());
        assertEquals("password1", foundMember.getPassword());
        assertEquals("phonenum1", foundMember.getPhoneNumber());
        assertEquals("loginId1", foundMember.getLoginId());

    }

    @DisplayName("회원Id로 회원 정보 조회 - 회원이 존재하지 않는 경우")
    @Test
    public void testGetMemberDetails_NotFound() {
        // given : 존재하지 않은 회원 ID
        Long nonMemberId = 9999L;

        // when
        Member foundMember = memberRepository.findById(nonMemberId).orElse(null);

        // then
        assertNull(foundMember); // 회원 정보가 null인지 확인

    }

    @DisplayName("로그인Id로 회원Id 찾기 - 회원이 존재하는 경우")
    @Test
    public void testGetMemberId_Success() {
        // given : 존재하는 로그인 ID
        entityManager.persist(member1);
        String existingLoginId = "loginId1";

        // when
        Optional<Member> op = memberRepository.findByLoginId(existingLoginId);

        // then
        Assertions.assertThat(op.isPresent()).isTrue();

    }

    @DisplayName("로그인Id로 회원Id 찾기 - 회원이 존재하지 않는 경우")
    @Test
    public void testGetMemberId_NotFound() {
        // given
        String nonLoginId = "nonLoginId";

        // when
        Optional<Member> op = memberRepository.findByLoginId(nonLoginId);

        // then

    }



    @DisplayName("SignUpRequest test")
    @Test
    public void testSignUpRequest_Success() {

        //given
        entityManager.persist(signUpRequest1);


        // when
        SignUpRequest createMember = signUpRequestRepository.findById(signUpRequest1.getMemberId()).orElse(null);


        assertEquals("mem2", createMember.getName());
        assertEquals("password2", createMember.getPassword());
        assertEquals("phonenum2", createMember.getPhoneNumber());
        assertEquals("loginId2", createMember.getLoginId());
    }


    @DisplayName("member create test")
    @Test
    public void testSignUp_Success() {
        entityManager.persist(signUpRequest1);

        // when
        SignUpRequest createMember = signUpRequestRepository.findById(signUpRequest1.getMemberId()).orElse(null);

        SignUpRequest saveMember = signUpRequestRepository.save(createMember);

        assertEquals(saveMember.getName(), createMember.getName());
        assertEquals(saveMember.getPassword(), createMember.getPassword());
        assertEquals(saveMember.getPhoneNumber(), createMember.getPhoneNumber());
        assertEquals(saveMember.getLoginId(), createMember.getLoginId());
    }

}
