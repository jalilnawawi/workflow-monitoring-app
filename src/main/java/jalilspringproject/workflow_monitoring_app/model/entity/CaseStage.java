package jalilspringproject.workflow_monitoring_app.model.entity;

import jakarta.persistence.*;
import jalilspringproject.workflow_monitoring_app.model.enums.StageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "case_stages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_stage_id")
    private Long id;

    // case_id (FK → ServiceCase.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_case_id", nullable = false)
    private ServiceCase serviceCase;

    // stage_template_id (FK → StageTemplate.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_template_id")
    private StageTemplate stageTemplate;

    // name (copy dari template)
    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StageStatus status;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @OneToMany(
            mappedBy = "caseStage",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Evidence> evidences;
}
