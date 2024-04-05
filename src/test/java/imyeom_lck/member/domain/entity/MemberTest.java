package imyeom_lck.member.domain.entity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import imyeom_lck.member.dummy.DummyMember;
import jakarta.persistence.EntityManager;

class MemberTest {

	Member member;


	@BeforeEach
	void setUp(){
		member = DummyMember.createDummyMember("hi", "test","010111222", "test");

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
		Long memberId = member.getMemberId();
		assertThat(memberId).isEqualTo(1L);
	}

	@Test
	void getPointUsages() {
	}

	@Test
	void getFinanceId() {
	}

	@Test
	void getLoginId() {
	}

	@Test
	void getPassword() {
	}

	@Test
	void getName() {
	}

	@Test
	void getPhoneNumber() {
	}

	@Test
	void getCheeringTeam() {
	}

	@Test
	void isConnectionStatus() {
	}

	@Test
	void getPoint() {
	}

	@Test
	void isAlert() {
	}

	@Test
	void isDeleted() {
	}

	@Test
	void setMemberId() {
	}

	@Test
	void setPointUsages() {
	}

	@Test
	void setFinanceId() {
	}

	@Test
	void setLoginId() {
	}

	@Test
	void setPassword() {
	}

	@Test
	void setName() {
	}

	@Test
	void setPhoneNumber() {
	}

	@Test
	void setCheeringTeam() {
	}

	@Test
	void setConnectionStatus() {
	}

	@Test
	void setPoint() {
	}

	@Test
	void setAlert() {
	}

	@Test
	void setDeleted() {
	}

	@Test
	void builder() {
	}
}