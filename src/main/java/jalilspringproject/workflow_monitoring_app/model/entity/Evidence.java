package jalilspringproject.workflow_monitoring_app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "evidences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // case_stage_id (FK → CaseStage.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_stage_id", nullable = false)
    private CaseStage caseStage;

    @Column(name = "file_url", nullable = false, length = 500)
    private String fileUrl;

    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @Column(name = "file_type", length = 100)
    private String fileType;

    @Column(columnDefinition = "TEXT")
    private String description;

    // uploaded_by (FK → User.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploaded_by", nullable = false)
    private User uploadedBy;
}
