package com.ducasagrande.StreamLab.services;

import com.ducasagrande.StreamLab.dtos.ResponseDto;
import com.ducasagrande.StreamLab.entities.VideoEntity;
import com.ducasagrande.StreamLab.repositories.VideoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public ResponseEntity<ResponseDto> listVideos() {
        List<VideoEntity> videos = videoRepository.findAll();

        if (videos.isEmpty()) {
            ResponseDto response = new ResponseDto("Nenhum vídeo encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        ResponseDto response = new ResponseDto(videos, "Vídeos encontrados com sucesso!", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
