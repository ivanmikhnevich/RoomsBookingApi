package ivanmikhnevich.orderapi.repository.TestClasses;

import ivanmikhnevich.orderapi.dao.AuditEvent;
import ivanmikhnevich.orderapi.repository.AbstractRepositoryTest;
import ivanmikhnevich.orderapi.repository.AuditEventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

class AuditEventRepositoryTest extends AbstractRepositoryTest {

    @Autowired AuditEventRepository audit;

    @Test
    void findTop100ByOrderByOccurredAtDesc() {
        em.persist(event("ROOM", "CREATE"));
        em.persist(event("ROOM", "UPDATE"));
        em.flush();
        assertThat(audit.findTop100ByOrderByOccurredAtDesc()).hasSize(2);
    }

    @Test
    void findAllByObjectTypeAndObjectId() {
        UUID id = UUID.randomUUID();
        em.persist(eventFor("ROOM", id, "CREATE"));
        em.persist(eventFor("ROOM", id, "UPDATE"));
        em.persist(eventFor("BOOKING", id, "CREATE"));
        em.flush();
        assertThat(audit.findAllByObjectTypeAndObjectIdOrderByOccurredAtDesc("ROOM", id)).hasSize(2);
    }

    private AuditEvent event(String type, String action) {
        return eventFor(type, UUID.randomUUID(), action);
    }

    private AuditEvent eventFor(String type, UUID id, String action) {
        AuditEvent e = new AuditEvent();
        e.setObjectType(type); e.setObjectId(id); e.setAction(action); e.setActorSubject("u");
        return e;
    }
}
