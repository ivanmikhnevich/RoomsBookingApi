package ivanmikhnevich.orderapi.repository;

import ivanmikhnevich.orderapi.dao.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID>{
    List<Booking> findAllByOwnerSubject(String ownerSubject);
    List<Booking> findAllByOwnerSubjectAndStartAtAfter(String OwnerSubject, OffsetDateTime now);
    List<Booking> findAllByRoomIdOrderByStartAtAsc(UUID roomId);
    boolean existsByIdAndStartAtAfter(UUID id, OffsetDateTime now);
    boolean existsByIdAndOwnerSubject(UUID id, String ownerSubject);
}
