package com.freeroom.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Base entity, to generate the ID
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @NotNull
    @Column(name = "VERSION")
    private long version;

    @Column(name = "LAST_MODIFIED_AT")
    protected Date lastModifiedAt = new Date();

    @Column(name = "CREATED_AT")
    private Date createdAt = new Date();

    public BaseEntity() {
    }

    @PrePersist
    public void onCreate() {
        createdAt = new Date();
        lastModifiedAt = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        lastModifiedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }
}
