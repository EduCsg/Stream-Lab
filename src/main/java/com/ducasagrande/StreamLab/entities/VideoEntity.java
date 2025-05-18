package com.ducasagrande.StreamLab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Entity
@Table(name = "videos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(nullable = false)
    private String title;

    private String description;

    @JsonIgnore
    @Column(name = "s3_url", nullable = false)
    private String s3Url;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.id == null)
            this.id = UUID.randomUUID().toString();

        this.createdAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
