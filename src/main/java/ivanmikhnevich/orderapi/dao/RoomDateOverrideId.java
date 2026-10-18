package ivanmikhnevich.orderapi.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RoomDateOverrideId implements Serializable {
    private static final long serialVersionUID = 3067769986315284205L;
    @Column(name = "room_id", nullable = false)
    private UUID roomId;

    @Column(name = "local_date", nullable = false)
    private LocalDate localDate;
}