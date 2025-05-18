package com.ducasagrande.StreamLab.repositories;

import com.ducasagrande.StreamLab.entities.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoEntity, String> {
}
