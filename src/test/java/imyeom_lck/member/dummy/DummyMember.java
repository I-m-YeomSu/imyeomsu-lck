package imyeom_lck.member.dummy;

import imyeom_lck.member.domain.entity.Member;

public class DummyMember {

    public static Member createDummyMember(String memberName, String password, String phoneNumber, String loginId) {
        Member member = new Member();
        member.setName(memberName);
        member.setPassword(password);
        member.setPhoneNumber(phoneNumber);
        member.setLoginId(loginId);
        return member;
    }
}
