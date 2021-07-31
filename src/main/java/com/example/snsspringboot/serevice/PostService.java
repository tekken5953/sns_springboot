package com.example.snsspringboot.serevice;

import com.example.snsspringboot.dao.PostDao;
import com.example.snsspringboot.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class PostService {

    public final PostDao postDao;

    @Autowired
    public PostService(@Qualifier("postDao") PostDao postDao) {
        this.postDao = postDao;
    }

    public int addPost(Post post) {
            return postDao.insertPost(post);
        }

    public List<Post> getAllPost() {
        return postDao.selectAllPost();
    }

    public Optional<Post> getPostById(UUID id){
        return postDao.selectPostById(id);
    }

    public Stream<Post> getPostByName(String name){
        return postDao.selectPostByName(name);
    }

    public Stream<Post> getPostByDate(String date) { return postDao.selectPostByDate(date); }

    public int deletePost(UUID id) {
        return postDao.deletePostId(id);
    }

    public int updatePost(UUID id, Post newPost) {
        return postDao.updatePostId(id, newPost);
    }

}