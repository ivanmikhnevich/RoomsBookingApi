package ivanmikhnevich.orderapi.repository;

import ivanmikhnevich.orderapi.dao.RoomEquipment;

import java.util.List;
import java.util.UUID;

public interface RoomEquipmentRepository {
    List<RoomEquipment> findAllByRoomId(UUID roomId);
}
