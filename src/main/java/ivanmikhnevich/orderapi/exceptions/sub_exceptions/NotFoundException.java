package ivanmikhnevich.orderapi.exceptions.sub_exceptions;

import ivanmikhnevich.orderapi.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {
    public NotFoundException(String errorCode, String message) {
        super(errorCode, message, HttpStatus.NOT_FOUND);
    }

    public static NotFoundException roomNotFound(){
        return new NotFoundException("ROOM_NOT_FOUND", "Room not found or unavailable");
    }

    public static NotFoundException bookingNotFound(){
        return new NotFoundException("BOOKING_NOT_FOUND", "Booking not found or unavailable");
    }
}