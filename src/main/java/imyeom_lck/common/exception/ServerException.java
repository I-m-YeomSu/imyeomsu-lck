package imyeom_lck.common.exception;

import imyeom_lck.common.code.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;


/*
* 500 - 서버 예외시 사용합니다.
* */
@Getter
public class ServerException extends RuntimeException{

    private final ErrorCode errorCode;
    private final HttpStatus responseStatus;
    private final String displayErrorMessage;


    public ServerException(ErrorCode errorCode, String message) {
        this(errorCode, errorCode.getName(), message);
    }
    public ServerException(ErrorCode errorCode, String message,
                           String displayErrorMessage) {
        super(message);
        this.errorCode = errorCode;
        this.responseStatus = errorCode.getResponseStatus();
        this.displayErrorMessage = displayErrorMessage;

    }

}