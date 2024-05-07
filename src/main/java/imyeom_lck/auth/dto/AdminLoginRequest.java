package imyeom_lck.auth.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginRequest {

    private String loginId;
    private String password;

}
