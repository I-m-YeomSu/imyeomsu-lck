package imyeom_lck.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SwaggerControllerAdvice {

    @ExceptionHandler(SwaggerException.class)
    public ResponseEntity<SwaggerResponseMessage> handleApiException(SwaggerException ex) {
        SwaggerResponseMessage SwaggerResponseMessage = ex.getSwaggerResponseMessage();
        return new ResponseEntity<>(SwaggerResponseMessage, HttpStatus.NOT_FOUND);
    }
}
