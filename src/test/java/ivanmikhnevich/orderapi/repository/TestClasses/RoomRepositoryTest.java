package ivanmikhnevich.orderapi.repository.TestClasses;

import ivanmikhnevich.orderapi.dao.Room;
import ivanmikhnevich.orderapi.dao.Booking;
import ivanmikhnevich.orderapi.enums.BookingStatus;
import ivanmikhnevich.orderapi.repository.AbstractRepositoryTest;
import ivanmikhnevich.orderapi.repository.RoomRepository;
import ivanmikhnevich.orderapi.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.OffsetDateTime;
import static org.assertj.core.api.Assertions.assertThat;

class RoomRepositoryTest extends AbstractRepositoryTest {

    @Autowired RoomRepository rooms;
    @Autowired BookingRepository bookings;

    @Test
    void findAllByActiveTrue() {
        em.persist(room("A", true));
        em.persist(room("B", false));
        em.flush();
        assertThat(rooms.findAllByActiveTrue()).extracting(Room::getCode).containsExactly("A");
    }

    @Test
    void findByCode() {
        em.persist(room("A", true));
        em.flush();
        assertThat(rooms.findByCode("A")).isPresent();
        assertThat(rooms.findByCode("Z")).isEmpty();
    }

    @Test
    void findAvailableRooms() {
        Room r = room("A", true);
        em.persist(r);
        em.persist(booking(r, "2025-01-01T10:00Z", "2025-01-01T12:00Z", BookingStatus.CONFIRMED));
        em.flush();
        var from = OffsetDateTime.parse("2025-01-01T11:00Z");
        var to   = OffsetDateTime.parse("2025-01-01T13:00Z");
        assertThat(rooms.findAvailableRooms(from, to, 5)).isEmpty();
        assertThat(rooms.findAvailableRooms(from, to, 1)).isEmpty();
        assertThat(rooms.findAvailableRooms(OffsetDateTime.parse("2025-01-01T13:00Z"), to.plusHours(2), 1))
                .extracting(Room::getCode).containsExactly("A");
    }

    private Room room(String code, boolean active) {
        Room r = new Room();
        r.setCode(code); r.setName(code); r.setCapacity(10); r.setActive(active);
        return r;
    }

    private Booking booking(Room r, String s, String e, BookingStatus st) {
        Booking b = new Booking();
        b.setRoom(r); b.setOwnerSubject("u"); b.setAttendees(1);
        b.setStartAt(OffsetDateTime.parse(s)); b.setEndAt(OffsetDateTime.parse(e)); b.setStatus(st);
        return b;
    }
}