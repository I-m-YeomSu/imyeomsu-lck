package imyeom_lck.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(SwaggerException.class)
    public ResponseEntity<SwaggerResponseMessage> handleSwaggerException(SwaggerException ex) {
        SwaggerResponseMessage swaggerResponseMessage = ex.getSwaggerResponseMessage();
        return new ResponseEntity<>(swaggerResponseMessage, HttpStatus.NOT_FOUND);
    }
}
