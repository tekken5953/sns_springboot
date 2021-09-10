package com.example.snsspringboot.dao;

import com.example.snsspringboot.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserDao {
    int insertUser(UUID id, User User);

    default int insertUser(User User) {
        UUID id = UUID.randomUUID();
        return insertUser(id, User);
    }

    List<User> selectAllUser();

    Optional<User> selectUserById(UUID id);

    Stream<User> selectUserByName(String name);

    int deleteUserId(UUID id);

    int updateUserId(UUID id, User User);

    int updateUserProfile(String profile, User user);
}
