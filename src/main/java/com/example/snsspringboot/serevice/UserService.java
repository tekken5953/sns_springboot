package com.example.snsspringboot.serevice;

import com.example.snsspringboot.model.User;
import com.example.snsspringboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class UserService {

    public final com.example.snsspringboot.dao.UserDao UserDao;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    public UserService(@Qualifier("userDao") UserDao UserDao) {
        this.UserDao = UserDao;
    }

    public int addUser(User User) {
            return UserDao.insertUser(User);
        }

    public List<User> getAllUser() {
        return UserDao.selectAllUser();
    }

    public Optional<User> getUserById(UUID id){
        return UserDao.selectUserById(id);
    }

    public Stream<User> getUserByName(String name){

        return UserDao.selectUserByName(name);
    }

    public int deleteUser(UUID id) {
        return UserDao.deleteUserId(id);
    }

    public int updateProfileByName(String name, User newUser) {
        return UserDao.updateProfileByName(name, newUser);
    }

    public int updatePwdByName(String name, User newUser) { return UserDao.updatePwdByName(name, newUser);}

}