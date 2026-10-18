package ivanmikhnevich.orderapi.repository.TestClasses;

import ivanmikhnevich.orderapi.dao.Room;
import ivanmikhnevich.orderapi.dao.Booking;
import ivanmikhnevich.orderapi.enums.BookingStatus;
import ivanmikhnevich.orderapi.repository.AbstractRepositoryTest;
import ivanmikhnevich.orderapi.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.OffsetDateTime;
import static org.assertj.core.api.Assertions.assertThat;

class BookingRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    BookingRepository bookings;

    @Test
    void findAllByOwnerSubject() {
        Room r = em.persist(room("A"));
        em.persist(booking(r, "u1", "2025-01-01T10:00Z"));
        em.persist(booking(r, "u2", "2025-01-02T10:00Z"));
        em.flush();
        assertThat(bookings.findAllByOwnerSubject("u1")).hasSize(1);
        assertThat(bookings.findAllByOwnerSubject("nobody")).isEmpty();
    }

    @Test
    void findAllByOwnerSubjectAndStartAtAfter() {
        Room r = em.persist(room("A"));
        em.persist(booking(r, "u1", "2025-01-01T10:00Z"));
        em.persist(booking(r, "u1", "2025-06-01T10:00Z"));
        em.flush();
        var now = OffsetDateTime.parse("2025-03-01T00:00Z");
        assertThat(bookings.findAllByOwnerSubjectAndStartAtAfter("u1", now)).hasSize(1);
    }

    @Test
    void existsByIdAndOwnerSubject() {
        Room r = em.persist(room("A"));
        Booking b = em.persist(booking(r, "u1", "2025-01-01T10:00Z"));
        em.flush();
        assertThat(bookings.existsByIdAndOwnerSubject(b.getId(), "u1")).isTrue();
        assertThat(bookings.existsByIdAndOwnerSubject(b.getId(), "u2")).isFalse();
    }

    @Test
    void existsByIdAndStartAtAfter() {
        Room r = em.persist(room("A"));
        Booking b = em.persist(booking(r, "u1", "2025-06-01T10:00Z"));
        em.flush();
        assertThat(bookings.existsByIdAndStartAtAfter(b.getId(), OffsetDateTime.parse("2025-01-01T00:00Z"))).isTrue();
        assertThat(bookings.existsByIdAndStartAtAfter(b.getId(), OffsetDateTime.parse("2025-12-01T00:00Z"))).isFalse();
    }

    private Room room(String code) {
        Room r = new Room();
        r.setCode(code); r.setName(code); r.setCapacity(10); r.setActive(true);
        return r;
    }

    private Booking booking(Room r, String owner, String start) {
        Booking b = new Booking();
        b.setRoom(r); b.setOwnerSubject(owner); b.setAttendees(1);
        b.setStartAt(OffsetDateTime.parse(start)); b.setEndAt(OffsetDateTime.parse(start).plusHours(1));
        b.setStatus(BookingStatus.CONFIRMED);
        return b;
    }
}