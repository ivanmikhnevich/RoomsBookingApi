package ivanmikhnevich.orderapi.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.List;

 @Data
 @Builder
public class ErrorResponse {
    private final String code;
    private final String message;
    private final String requestId;
    private final List<FieldError> fieldErrors;

    @Data
    @Builder
    public static class FieldError {
        private String field;
        private String message;
        private Object rejectedValue;
    }
}
