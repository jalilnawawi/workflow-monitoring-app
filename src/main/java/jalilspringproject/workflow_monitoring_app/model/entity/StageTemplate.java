package jalilspringproject.workflow_monitoring_app.model.entity;

import jakarta.persistence.*;
import jalilspringproject.workflow_monitoring_app.model.enums.EvidenceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "stage_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StageTemplate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stage_template_id")
    private Long id;

    // workflow_id (FK → WorkflowTemplate.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_id", nullable = false)
    private WorkflowTemplate workflowTemplate;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    @Column(name = "required_evidence", nullable = false)
    private Boolean requiredEvidence;

    @Enumerated(EnumType.STRING)
    @Column(name = "evidence_type", nullable = false, length = 30)
    private EvidenceType evidenceType;

    @Column(name = "evidence_instruction", columnDefinition = "TEXT")
    private String evidenceInstruction;

    @OneToMany(
            mappedBy = "stageTemplate",
            fetch = FetchType.LAZY
    )
    private List<CaseStage> caseStages;
}
