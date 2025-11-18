package jalilspringproject.workflow_monitoring_app.repository;

import jalilspringproject.workflow_monitoring_app.model.entity.WorkflowTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkflowTemplateRepository extends JpaRepository<WorkflowTemplate, Long> {
}
