package imyeom_lck.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SwaggerResponseMessage {
    private int code;
    private String msg;
}
