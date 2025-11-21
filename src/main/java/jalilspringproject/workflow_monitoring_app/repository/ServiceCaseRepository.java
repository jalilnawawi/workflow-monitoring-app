package jalilspringproject.workflow_monitoring_app.repository;

import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.SummaryServiceCaseByStatusProjection;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.TrackingCodeProjection;
import jalilspringproject.workflow_monitoring_app.model.entity.ServiceCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = """
                   select\s
                   	sc.tracking_code as trackingCode,
                   	wt.name as workflow,
                   	cs.name as tahapan,
                   	cs.status as status
                   from service_cases sc
                   join workflow_templates wt on wt.workflow_template_id = sc.workflow_id
                   join case_stages cs on cs.service_case_id = sc.service_case_id
                   where sc.tracking_code = :trackingCode
                   order by cs.order_index ASC
                   """,
            nativeQuery = true
    )
    List<TrackingCodeProjection> getServiceCaseByTrackingCode(@Param("trackingCode") String trackingCode);
}
