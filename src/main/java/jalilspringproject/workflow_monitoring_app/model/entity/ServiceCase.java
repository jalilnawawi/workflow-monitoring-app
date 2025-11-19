package jalilspringproject.workflow_monitoring_app.model.entity;

import jakarta.persistence.*;
import jalilspringproject.workflow_monitoring_app.model.enums.CaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "service_cases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_case_id")
    private Long id;

    // service_type_id (FK → ServiceType.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    // workflow_id (snapshot workflow saat dibuat)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_id", nullable = false)
    private WorkflowTemplate workflowTemplate;

    // user_id (FK → User.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // client_name (cached)
    @Column(name = "username", nullable = false, length = 150)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private CaseStatus status;

    @Column(name = "tracking_code", nullable = false, unique = true, length = 100)
    private String trackingCode;

    @OneToMany(
            mappedBy = "serviceCase",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<CaseStage> stages;
}
