package imyeom_lck.common.advice;

import imyeomsu.lck.common_utils.dto.ResponseDto;
import imyeomsu.lck.common_utils.exception.ClientException;
import imyeomsu.lck.common_utils.exception.ServerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CommonRestControllerAdviceTest {

    private MockMvc mockMvc;

    @Mock
    private ClientException clientExceptionMock;

    @Mock
    private ServerException serverException;

    @InjectMocks
    private CommonRestControllerAdvice controllerAdvice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("공통으로 사용하는 ClientException 대응하는 RestControllerAdvice 테스트")
    @Test
    void testClientExceptionHandler() {
        // Mocking
        when(clientExceptionMock.getResponseStatus()).thenReturn(HttpStatus.BAD_REQUEST);
        when(clientExceptionMock.getDisplayErrorMessage()).thenReturn("Client error");

        // Invocation
        ResponseEntity<ResponseDto<?>> responseEntity = controllerAdvice.clientExceptionHandler(clientExceptionMock);

        // Assertions
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(false, responseEntity.getBody().isSuccess());
        assertEquals("Client error", responseEntity.getBody().getErrorMessages().get(0)); // Assuming getErrorMessages() returns a List
    }

    @DisplayName("공통으로 사용하는 ServerException 대응하는 RestControllerAdvice 테스트")
    @Test
    void testServerExceptionHandler() {
        // Mocking
        when(serverException.getResponseStatus()).thenReturn(HttpStatus.BAD_REQUEST);
        when(serverException.getDisplayErrorMessage()).thenReturn("Server error");

        // Invocation
        ResponseEntity<ResponseDto<?>> responseEntity = controllerAdvice.serverExceptionHandler(serverException);

        // Assertions
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(false, responseEntity.getBody().isSuccess());
        assertEquals("Server error", responseEntity.getBody().getErrorMessages().get(0)); // Assuming getErrorMessages() returns a List
    }


}