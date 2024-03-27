package imyeom_lck.common.advice;

import imyeom_lck.common.dto.ResponseDto;
import imyeom_lck.common.exception.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * 공용으로 예외  처리를 담당하는 어드바이스 입니다.
 * 각 메서드 마다 ExceptionHandler를 통한 처리가 가능하지만
 * 공통 처리를 원한다면 해당 애너테이션을 사용해 진행합니다.
 * */
@RestControllerAdvice
@Slf4j
public class CommonRestControllerAdvice {

//    /**
//     * NOT_FOUND와 관련된 예외를 처리하는 핸들러
//     * */
//    @ExceptionHandler(value = {NotFoundMemberException.class,
//            NotFoundMemberRoleException.class,
//            NotFoundRoleTypeException.class,
//            NotFoundProductTypeException.class
//    })
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<String> notFoundExceptionHandler(Exception ex){
//        log.error("[NOT_FOUND] notFoundExceptionHandler ", ex);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//
//
//    /**
//     * CONFLICT와 관련된 예외를 처리하는 핸들러
//     * */
//    @ExceptionHandler(value = {AlreadyExistsMember.class,
//            AlreadyExistsMemberProfile.class
//
//    })
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public ResponseEntity<String> alreadyExistsExceptionHandler(Exception ex){
//        log.error("[CONFLICT] alreadyExistsExceptionHandler ", ex);
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
//    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ResponseDto<Object>> clientExceptionHandler(ClientException e){

        ResponseDto<Object> response = ResponseDto.builder()
                .success(false)
                .status(e.getResponseStatus())
                .errorMessages(List.of(e.getDisplayErrorMessage())).build();

        return ResponseEntity.status(e.getResponseStatus()).body(response);

    }

}