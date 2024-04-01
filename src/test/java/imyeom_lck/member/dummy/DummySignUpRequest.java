package imyeom_lck.member.dummy;

import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.domain.entity.SignUpRequest;

public class DummySignUpRequest {

    public static SignUpRequest createDummyUser(String memberName, String password, String phoneNumber, String loginId) {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setLoginId(loginId);
        signUpRequest.setPassword(password);
        signUpRequest.setName(memberName);
        signUpRequest.setPhoneNumber(phoneNumber);
        return signUpRequest;
    }

}
