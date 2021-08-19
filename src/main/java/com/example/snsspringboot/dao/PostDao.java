package com.example.snsspringboot.dao;

import com.example.snsspringboot.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface PostDao {
    int insertPost(UUID id, Post post);

    default int insertPost(Post Post) {
        UUID id = UUID.randomUUID();
        return insertPost(id, Post);
    }

    List<Post> selectAllPost();

    Optional<Post> selectPostById(UUID id);

    Stream<Post> selectPostByName(String name);

    Stream<Post> selectPostByDate(String date);

    int deletePostId(UUID id);

    int updatePostId(UUID id, Post post);

    List<Post> deleteAllPost();
}
