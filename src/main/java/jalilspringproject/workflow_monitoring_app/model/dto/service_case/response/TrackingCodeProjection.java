package jalilspringproject.workflow_monitoring_app.model.dto.service_case.response;

public interface TrackingCodeProjection {
    String getTrackingCode();
    String getWorkflow();
    String getTahapan();
    String getStatus();
}