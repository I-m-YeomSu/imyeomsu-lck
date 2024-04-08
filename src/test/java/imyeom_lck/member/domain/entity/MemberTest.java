package imyeom_lck.member.domain.entity;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import imyeom_lck.member.dummy.DummyMember;

class MemberTest {

	Member member;
	Member member1;

	@BeforeEach
	void setUp(){
		member = DummyMember.createDummyMember("hi", "test","010111222", "test");
		member1 = Member.builder().financeId(1L)
				.password("pwd")
				.name("test")
				.loginId("test")
				.phoneNumber("01022223333")
				.cheeringTeam("1")
				.connectionStatus(false)
				.point(1000)
				.alert(false)
				.isDeleted(false).build();
	}

	@Test
	@DisplayName("회원 삭제 테스트")
	void deletedMember() {

		member.deletedMember("test");

		assertThat(member.isDeleted()).isTrue();

	}


	@Test
	@DisplayName("회원 id값 찾는 테스트")
	void getMemberId() {
		Long memberId = member1.getMemberId();
		assertThat(memberId).isEqualTo(2L);
	}

	@Test
	void getPointUsages() {

		int point = member1.getPoint();
		assertThat(point).isEqualTo(1000);

	}

	@Test
	void getFinanceId() {

		Long financeId = member1.getFinanceId();

		assertThat(financeId).isEqualTo(1L);
	}

	@Test
	void getLoginId() {
		String loginId = member1.getLoginId();

		assertThat(loginId).isEqualTo("test");

	}

	@Test
	void getPassword() {

		String password = member1.getPassword();

		assertThat(password).isEqualTo("pwd");
	}

	@Test
	void getName() {
		String name = member1.getName();
		assertThat(name).isEqualTo("test");
	}

	@Test
	void getPhoneNumber() {
		String phoneNumber = member1.getPhoneNumber();
		assertThat(phoneNumber).isEqualTo("01022223333");

	}

	@Test
	void getCheeringTeam() {

		String cheeringTeam = member1.getCheeringTeam();
		assertThat(cheeringTeam).isEqualTo("1");
	}

	@Test
	void isConnectionStatus() {


		assertThat(member1.isConnectionStatus()).isFalse();
	}

	@Test
	void getPoint() {
		assertThat(member1.getPoint()).isEqualTo(1000);
	}

	@Test
	void isAlert() {

		assertThat(member1.isAlert()).isFalse();
	}

	@Test
	void isDeleted() {
		assertThat(member1.isDeleted()).isFalse();

	}

}