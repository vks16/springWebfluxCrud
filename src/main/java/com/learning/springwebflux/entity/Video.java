package com.learning.springwebflux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "videos")
public class Video {
    @Id
    private String id;
    private String title;
    private String thumbnail;
    private String url;
}
