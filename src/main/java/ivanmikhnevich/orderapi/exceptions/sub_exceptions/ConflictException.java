package ivanmikhnevich.orderapi.exceptions.sub_exceptions;

import ivanmikhnevich.orderapi.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class ConflictException extends ApiException {
    public ConflictException(String errorCode, String message) {
        super(errorCode, message, HttpStatus.CONFLICT);
    }

    public static ConflictException roomUnavailable(){
        return new ConflictException("ROOM_UNAVAILABLE", "Room reserved by someone else");
    }

    public static ConflictException staleBookingVersion(){
        return new ConflictException("STALE_BOOKING_VERSION", "Booking has changed from the moment of reading by client");
    }

    public static ConflictException bookingAlreadyStarted(){
        return new ConflictException("BOOKING_ALREADY_STARTED", "Can't change started booking");
    }

    public static ConflictException roomHasFutureBookings(){
        return new ConflictException("ROOM_HAS_FUTURE_BOOKINGS", "Modification the room will break future bookings");
    }
}
