package jalilspringproject.workflow_monitoring_app.repository;

import jalilspringproject.workflow_monitoring_app.model.entity.StageTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageTemplateRepository extends JpaRepository<StageTemplate, Long> {
}
