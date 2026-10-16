package ivanmikhnevich.orderapi.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
public class ApiException extends RuntimeException {
    private final String errorCode;
    private final HttpStatus httpStatus;
    private final List<ErrorResponse.FieldError> fieldErrors;

    public ApiException (String errorCode, String message, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.fieldErrors = Collections.emptyList();
    }

    public ApiException (String errorCode, String message, HttpStatus httpStatus, List<ErrorResponse.FieldError> fieldErrors) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.fieldErrors = fieldErrors;
    }
}
