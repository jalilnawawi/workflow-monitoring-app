package jalilspringproject.workflow_monitoring_app.repository;

import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.SummaryServiceCaseByStatusProjection;
import jalilspringproject.workflow_monitoring_app.model.entity.ServiceCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceCaseRepository extends JpaRepository<ServiceCase, Long> {

    @Query(value = """
                   SELECT
                          sc.status AS status,
                          COUNT(sc.service_case_id) AS count
                   FROM service_cases sc
                   GROUP BY sc.status
                   """,
            nativeQuery = true
    )
    List<SummaryServiceCaseByStatusProjection> getSummaryByStatus();
}
