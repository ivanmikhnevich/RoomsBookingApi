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
public class RoomWeeklyHourId implements Serializable {
    private static final long serialVersionUID = 1232685028200259657L;
    @Column(name = "room_id", nullable = false)
    private UUID roomId;

    @Column(name = "day_of_week", nullable = false)
    private Short dayOfWeek;


}