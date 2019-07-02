package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.User;
import com.metodologia.gotomovie.repository.UserRepository2;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {
    @Autowired
    UserRepository2 userRepository2;

    public void addUser(User user) throws Exception {
        userRepository2.addUser(user);
    }

    public List<User> getAll() {
        return userRepository2.getAll();
    }

    public User verificarUsuario(String userName, String pass) {
        return userRepository2.getUserByPassword(userName,pass);
    }
}
