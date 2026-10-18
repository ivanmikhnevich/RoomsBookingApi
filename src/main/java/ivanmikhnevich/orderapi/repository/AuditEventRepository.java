package ivanmikhnevich.orderapi.repository;


import ivanmikhnevich.orderapi.dao.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuditEventRepository extends JpaRepository<AuditEvent, Long> {
    List<AuditEvent> findAllByObjectTypeAndObjectIdOrderByOccurredAtDesc(String objectType, UUID objectId);
    List<AuditEvent> findTop100ByOrderByOccurredAtDesc();
}
