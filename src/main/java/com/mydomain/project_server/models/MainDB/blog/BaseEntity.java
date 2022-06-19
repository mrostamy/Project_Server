package com.mydomain.project_server.models.MainDB.blog;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})//barrasy shavad
public class BaseEntity<T extends Serializable> implements Serializable {

    @Id
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    private void persistTime() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void updateTime() {
        this.updatedAt = LocalDateTime.now();
    }
}
