package ivanmikhnevich.orderapi.exceptions.sub_exceptions;

import ivanmikhnevich.orderapi.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApiException {
    public ForbiddenException(String message) {
        super("Forbidden", message, HttpStatus.FORBIDDEN);
    }
}
