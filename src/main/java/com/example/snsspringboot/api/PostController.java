package com.example.snsspringboot.api;

import com.example.snsspringboot.model.Post;
import com.example.snsspringboot.serevice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void addPost(@Valid @NonNull @RequestBody Post post) {
        postService.addPost(post);
    }

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping(path = "/id/{id}")
    public Post getPostById(@PathVariable("id") UUID id) {
        return postService.getPostById(id)
                .orElse(null);
    }

    @GetMapping(path = "/name/{name}")
    public Stream<Post> getPostByName(@PathVariable("name") String name) {
        return postService.getPostByName(name);
    }

    @GetMapping(path = "/date/{date}")
    public Stream<Post> getPostByDate(@PathVariable("date") String date) { return postService.getPostByDate(date);}

    @DeleteMapping(path = "{id}")
    public void deletePostById(@PathVariable("id") UUID id) {
        postService.deletePost(id);
    }

    @PutMapping(path = "{id}")
    public void updatePostById(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Post postToUpdate) {
        postService.updatePost(id, postToUpdate);
    }

    @DeleteMapping
    public void deleteAllPost() {postService.deleteAllPost();}
}
