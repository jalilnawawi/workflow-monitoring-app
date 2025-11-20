package jalilspringproject.workflow_monitoring_app.repository;

import jalilspringproject.workflow_monitoring_app.model.entity.StageTemplate;
import jalilspringproject.workflow_monitoring_app.model.entity.WorkflowTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkflowTemplateRepository extends JpaRepository<WorkflowTemplate, Long> {

    @Query(value = """
                   SELECT *
                   FROM stage_templates st
                     WHERE st.workflow_id = :workflowTemplateId
                   """,
            nativeQuery = true
    )
    List<StageTemplate> findStageTemplatesByWorkflowTemplateId(Long workflowTemplateId);
}
