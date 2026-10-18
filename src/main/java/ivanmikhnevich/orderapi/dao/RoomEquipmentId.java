package ivanmikhnevich.orderapi.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RoomEquipmentId implements Serializable {
    private static final long serialVersionUID = -7622415102368990172L;
    @Column(name = "room_id", nullable = false)
    private UUID roomId;

    @Column(name = "equipment_code", nullable = false, length = 50)
    private String equipmentCode;


}