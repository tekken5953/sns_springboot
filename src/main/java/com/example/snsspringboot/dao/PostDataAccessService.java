package com.example.snsspringboot.dao;

import com.example.snsspringboot.dao.PostDao;
import com.example.snsspringboot.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository("postDao")
public class PostDataAccessService implements PostDao {
    private static List<Post> DB = new ArrayList<>();

    @Override
    public int insertPost(UUID id, Post post) {
        DB.add(new Post(id, post.getName(), post.getDate(), post.getPost_content(), post.getPhoto(), post.getHeart_count(), post.getComment_count()));
        return 1;
    }

    @Override
    public List<Post> selectAllPost() {
        return DB;
    }

    @Override
    public Optional<Post> selectPostById(UUID id) {
        return DB.stream()
                .filter(Post -> Post.getId().equals(id))
                .findFirst();
    }

    @Override
    public Stream<Post> selectPostByName(String name) {
        return DB.stream()
                .filter(Post -> Post.getName().equals(name));
    }

    @Override
    public Stream<Post> selectPostByDate(String date) {
        return DB.stream()
                .filter(Post -> Post.getDate().equals(date));
    }

    @Override
    public int deletePostId(UUID id) {
        Optional<Post> PostMaybe = selectPostById(id);
        if (PostMaybe.isPresent()) {
            return 0;
        }
        DB.remove(PostMaybe.get());
        return 1;
    }

    @Override
    public int updatePostId(UUID id, Post update) {
        return selectPostById(id)
                .map(Post -> {
                    int indexOfPostToUpdate = DB.indexOf(Post);
                    if (indexOfPostToUpdate >= 0) {
                        DB.set(indexOfPostToUpdate,
                                new Post(id, update.getName(), update.getDate(), update.getPost_content(), update.getPhoto(), update.getHeart_count(), update.getComment_count()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}