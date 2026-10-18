package ivanmikhnevich.orderapi.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "audit_events")
public class AuditEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "object_type", nullable = false, length = 50)
    private String objectType;

    @Column(name = "object_id", nullable = false)
    private UUID objectId;

    @Column(name = "action", nullable = false, length = 50)
    private String action;

    @Column(name = "actor_subject", nullable = false)
    private String actorSubject;

    @CreationTimestamp
    @ColumnDefault("now()")
    @Column(name = "occurred_at", nullable = false)
    private OffsetDateTime occurredAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "before_data")
    private Map<String, Object> beforeData;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "after_data")
    private Map<String, Object> afterData;


}