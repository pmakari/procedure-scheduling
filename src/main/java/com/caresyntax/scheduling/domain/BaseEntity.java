package com.caresyntax.scheduling.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Parviz on 10.05.2018.
 * All entities should extend this entity to have common fields and version field for optimistic locking
 */
@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

//    @Version
//    private long version;

    //Would work if spring security is used
    @Column(name = "created_by", updatable = false, length = 128)
    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    @Column(name = "modified_by", length = 128)
    private String modifiedBy;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }
}
