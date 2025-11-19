package jalilspringproject.workflow_monitoring_app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "service_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(
            mappedBy = "serviceType",
            fetch = FetchType.LAZY
    )
    private List<WorkflowTemplate> workflows;

    @OneToMany(
            mappedBy = "serviceType",
            fetch = FetchType.LAZY
    )
    private List<ServiceCase> cases;
}
