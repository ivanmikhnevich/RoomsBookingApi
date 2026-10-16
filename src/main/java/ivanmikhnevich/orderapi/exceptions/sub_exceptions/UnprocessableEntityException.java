package ivanmikhnevich.orderapi.exceptions.sub_exceptions;

import ivanmikhnevich.orderapi.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends ApiException {
    public UnprocessableEntityException(String errorCode, String message) {
        super(errorCode, message, HttpStatus.UNPROCESSABLE_CONTENT);
    }

    public static UnprocessableEntityException outsideWorkingHours() {
        return new UnprocessableEntityException("OUTSIDE_WORKING_HOURS", "Interval out of working hours");
    }

    public static UnprocessableEntityException invalidLocalTime() {
        return new UnprocessableEntityException("INVALID_LOCAL_TIME", "Interval is invalid for office's time zone");
    }

    public static UnprocessableEntityException bookingRuleViolation(String details) {
        return new UnprocessableEntityException("BOOKING_RULE_VIOLATION", "Booking rules violation: " + details);
    }
}