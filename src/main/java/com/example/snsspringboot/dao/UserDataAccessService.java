package com.example.snsspringboot.dao;

import com.example.snsspringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository("userDao")
public class UserDataAccessService implements UserDao {
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User User) {
        DB.add(new User(id, User.getName(), User.getPhone(), User.getPwd(), User.getRepeat_pwd(), User.getProfile()));
        return 1;
    }

    @Override
    public List<User> selectAllUser() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(User -> User.getId().equals(id))
                .findFirst();
    }

    @Override
    public Stream<User> selectUserByName(String name) {
        return DB.stream()
                .filter(User -> User.getName().equals(name));
    }

    @Override
    public int deleteUserId(UUID id) {
        Optional<User> UserMaybe = selectUserById(id);
        if (UserMaybe.isPresent()) {
            return 0;
        }
        DB.remove(UserMaybe.get());
        return 1;
    }

    public int updateProfileByName(String name, User update) {
        return selectUserByName(name)
                .map(User -> {
                    int indexOfUserToUpdate = DB.indexOf(User);
                    if (indexOfUserToUpdate >= 0) {
                        DB.set(indexOfUserToUpdate, new User(User.getId(), name, User.getPhone(), User.getPwd(), User.getRepeat_pwd(), update.getProfile()));
                        return 1;
                    }
                    return 0;
                })
                .findFirst().orElse(0);
    }

    public int updatePwdByName(String name, User update) {
        return selectUserByName(name)
                .map(User -> {
                    int indexOfUserToUpdate = DB.indexOf(User);
                    if (indexOfUserToUpdate >= 0) {
                        DB.set(indexOfUserToUpdate, new User(User.getId(), name, User.getPhone(), update.getPwd(), update.getRepeat_pwd(), User.getProfile()));
                        return 1;
                    }
                    return 0;
                })
                .findFirst().orElse(0);
    }
}