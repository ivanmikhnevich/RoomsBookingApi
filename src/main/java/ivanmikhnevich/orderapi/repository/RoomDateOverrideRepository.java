package ivanmikhnevich.orderapi.repository;

import ivanmikhnevich.orderapi.dao.RoomDateOverride;
import ivanmikhnevich.orderapi.dao.RoomDateOverrideId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomDateOverrideRepository extends JpaRepository<RoomDateOverride, RoomDateOverrideId> {
    Optional<RoomDateOverride> findByIdRoomIdAndIdLocalDate(UUID roomId, LocalDate localDate);
}
