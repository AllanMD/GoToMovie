package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.User;
import com.metodologia.gotomovie.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user) throws Exception {
        userRepository.addUser(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User verificarUsuario(String userName, String pass) {
        return userRepository.getUserByPassword(userName,pass);
    }
}
