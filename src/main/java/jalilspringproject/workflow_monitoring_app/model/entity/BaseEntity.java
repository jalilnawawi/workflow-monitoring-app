package jalilspringproject.workflow_monitoring_app.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @Column(name = "deleted_at")
    @UpdateTimestamp
    private LocalDateTime deletedAt;
}