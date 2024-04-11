package imyeom_lck.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SwaggerException extends RuntimeException {
    private SwaggerResponseMessage swaggerResponseMessage;
}
