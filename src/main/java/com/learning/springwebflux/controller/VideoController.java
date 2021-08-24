package com.learning.springwebflux.controller;

import com.learning.springwebflux.dto.VideoDto;
import com.learning.springwebflux.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping
    public Flux<VideoDto> getVideos(){
        return videoService.getVideos();
    }

    @GetMapping("/{id}")
    public Mono<VideoDto> getVideo(@PathVariable String id){
        return videoService.getVideo(id);
    }

    @PostMapping
    public Mono<VideoDto> addVideo(@RequestBody Mono<VideoDto> video){
        return videoService.saveVideo(video);
    }

    @PutMapping("/{id}")
    public Mono<VideoDto> updateVideo(@PathVariable String id, @RequestBody Mono<VideoDto> video){
        return videoService.updateVideo(video, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteVideo(@PathVariable String id){
        return videoService.deleteVideo(id);
    }
}
