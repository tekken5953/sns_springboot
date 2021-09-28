package com.example.snsspringboot.api;

import com.example.snsspringboot.model.User;
import com.example.snsspringboot.serevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Valid @NonNull @RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping(path = "/id/{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id)
                .orElse(null);
    }

    @GetMapping(path = "/name/{name}")
    public Stream<User> getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
    }

    @PutMapping(path = "/name/{name}")
    public void updateProfileByName(@PathVariable("name") String name, @Valid @NonNull @RequestBody User userToUpdate) {
        userService.updateProfileByName(name, userToUpdate);
    }
}
