package jalilspringproject.workflow_monitoring_app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "workflow_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowTemplate extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workflow_template_id")
    private Long id;

    // service_type_id (FK → ServiceType.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "is_active", nullable = false)
    private Boolean active;

    @OneToMany(
            mappedBy = "workflowTemplate",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<StageTemplate> stages;

    @OneToMany(
            mappedBy = "workflowTemplate",
            fetch = FetchType.LAZY
    )
    private List<ServiceCase> cases;
}
