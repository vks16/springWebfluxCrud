package com.learning.springwebflux.service;

import com.learning.springwebflux.dto.VideoDto;
import com.learning.springwebflux.entity.Video;
import com.learning.springwebflux.repository.VideoRepository;
import com.learning.springwebflux.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VideoService{
    @Autowired
    private VideoRepository videoRepository;

    public Flux<VideoDto> getVideos() {
        return videoRepository.findAll().map(AppUtils::videoToVideoDto);
    }

    public Mono<VideoDto> getVideo(String id) {
        return videoRepository.findById(id).map(AppUtils::videoToVideoDto);
    }

    public Mono<VideoDto> saveVideo(Mono<VideoDto> videoDtoMono){

        return videoDtoMono.map(AppUtils::videoDtoToVideo)
                .flatMap(videoRepository::insert)
                .map(AppUtils::videoToVideoDto);
    }

    public Mono<VideoDto> updateVideo(Mono<VideoDto> videoDtoMono, String id) {
        return videoRepository.findById(id) // got data from database
                .flatMap(p -> videoDtoMono.map(AppUtils::videoDtoToVideo) // converting entity to dto
                                .doOnNext(e -> e.setId(id))) // keeping id same during update
                                .flatMap(videoRepository::save) // saving
                            .map(AppUtils::videoToVideoDto); // converting to dto
    }

    public Mono<Void> deleteVideo(String id) {
        return videoRepository.deleteById(id);
    }
}
