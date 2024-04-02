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
}
