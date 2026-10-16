package ivanmikhnevich.orderapi.exceptions.sub_exceptions;

import ivanmikhnevich.orderapi.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiException {
    public UnauthorizedException(String message) {
        super("Unauthorized", message, HttpStatus.UNAUTHORIZED);
    }
}
