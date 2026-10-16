package ivanmikhnevich.orderapi.exceptions.sub_exceptions;

import ivanmikhnevich.orderapi.exceptions.ApiException;
import ivanmikhnevich.orderapi.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public class InvalidRequestException extends ApiException {
    public InvalidRequestException(String message, List<ErrorResponse.FieldError> fieldErrors) {
        super("Invalid Request", message, HttpStatus.BAD_REQUEST, fieldErrors);
    }
}
