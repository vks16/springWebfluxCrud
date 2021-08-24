package com.learning.springwebflux.repository;

import com.learning.springwebflux.entity.Video;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends ReactiveMongoRepository<Video, String> {

}
