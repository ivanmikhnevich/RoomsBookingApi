package ivanmikhnevich.orderapi.repository;

import ivanmikhnevich.orderapi.dao.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID>{

    List<Room> findAllByActiveTrue();

    Optional<Room> findByCode(String code);

    @Query (
        "SELECT r FROM Room r " +
        "WHERE r.active = true " +
        "AND (r.capacity >= :attendees) " +
        "AND NOT EXISTS (" +
            "SELECT 1 FROM Booking b " +
            "WHERE (b.room.id = r.id) " +
            "AND b.status = ivanmikhnevich.orderapi.enums.BookingStatus.CONFIRMED " +
            "AND b.startAt < :endAt " +
            "AND b.endAt > :startAt" +
            ")"
    )
    List<Room> findAvailableRooms(
            @Param("startAt") OffsetDateTime startAt,
            @Param("endAt") OffsetDateTime endAt,
            @Param("attendees") Integer attendees
    );
}