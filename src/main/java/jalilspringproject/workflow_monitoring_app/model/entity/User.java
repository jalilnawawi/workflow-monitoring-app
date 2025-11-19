package jalilspringproject.workflow_monitoring_app.model.entity;

import jakarta.persistence.*;
import jalilspringproject.workflow_monitoring_app.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Column(nullable = false, length = 150)
    private String name;

    @OneToMany(mappedBy = "uploadedBy", fetch = FetchType.LAZY)
    private List<Evidence> uploadedEvidences;
}
