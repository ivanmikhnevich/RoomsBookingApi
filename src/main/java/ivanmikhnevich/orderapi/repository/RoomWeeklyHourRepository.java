package ivanmikhnevich.orderapi.repository;

import ivanmikhnevich.orderapi.dao.RoomWeeklyHour;
import ivanmikhnevich.orderapi.dao.RoomWeeklyHourId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoomWeeklyHourRepository extends JpaRepository<RoomWeeklyHour, RoomWeeklyHourId> {
    List<RoomWeeklyHour> findAllByRoomId(UUID roomId);
}
