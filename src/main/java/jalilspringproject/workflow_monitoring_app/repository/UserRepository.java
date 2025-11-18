package jalilspringproject.workflow_monitoring_app.repository;

import jalilspringproject.workflow_monitoring_app.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
