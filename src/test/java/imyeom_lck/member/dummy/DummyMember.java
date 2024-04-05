package imyeom_lck.member.dummy;

import imyeom_lck.member.domain.entity.Member;

public class DummyMember {

    public static Member createDummyMember(String memberName, String password, String phoneNumber, String loginId) {
        return Member.builder()
                .name(memberName)
                .password(password)
                .phoneNumber(phoneNumber)
                .loginId(loginId)
                .build();
    }

    public static Member dummy(){
        return Member.builder()
                .financeId(1L)
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
}
