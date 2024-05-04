package imyeom_lck.common.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class ExceptionHandlerController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object errorStatusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (Objects.nonNull(errorStatusCode)) {
            int statusCode = Integer.parseInt(errorStatusCode.toString());

            // 400
            if (Objects.equals(statusCode, HttpStatus.BAD_REQUEST.value())) {
                return "/error/400.html";
            }
            // 404
            else if (Objects.equals(statusCode, HttpStatus.NOT_FOUND.value())) {
                return "/error/404.html";
            }
            // 500
            else if (Objects.equals(statusCode, HttpStatus.INTERNAL_SERVER_ERROR.value())) {
                return "/error/500.html";
            }
        }

        return "common/errors/error";
    }

}
