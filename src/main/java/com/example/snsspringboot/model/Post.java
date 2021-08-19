package com.example.snsspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Post {

    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String date;
    @NotBlank
    private final String post_content;
    @NotBlank
    private final String photo;
    @NotBlank
    private final Integer heart_count;
    @NotBlank
    private final Integer comment_count;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPost_content() {
        return post_content;
    }

    public String getPhoto() {
        return photo;
    }

    public Integer getHeart_count() {
        return heart_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public Post(@JsonProperty("id") UUID id,
                @JsonProperty("name") @NotBlank String name,
                @JsonProperty("date") @NotBlank String date,
                @JsonProperty("content") @NotBlank String post_content,
                @JsonProperty("photo") @NotBlank String photo,
                @JsonProperty("heart") @NotBlank Integer heart_count,
                @JsonProperty("comment") @NotBlank Integer comment_count) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.post_content = post_content;
        this.photo = photo;
        this.heart_count = heart_count;
        this.comment_count = comment_count;
    }
}
