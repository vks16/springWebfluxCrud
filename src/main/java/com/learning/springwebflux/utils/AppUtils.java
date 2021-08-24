package com.learning.springwebflux.utils;

import com.learning.springwebflux.dto.VideoDto;
import com.learning.springwebflux.entity.Video;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static VideoDto videoToVideoDto(Video video){
        VideoDto videoDto = new VideoDto();
        BeanUtils.copyProperties(video, videoDto);
        return videoDto;
    }

    public static Video videoDtoToVideo(VideoDto videoDto){
        Video video = new Video();
        BeanUtils.copyProperties(videoDto, video);
        return video;
    }
}
