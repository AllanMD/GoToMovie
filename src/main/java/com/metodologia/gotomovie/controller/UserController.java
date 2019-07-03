package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.User;
import com.metodologia.gotomovie.repository.UserRepository;
import com.metodologia.gotomovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public void createUser (@RequestBody User user) throws SQLException {
        userRepository.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocurrio un error");
        }
        return user;
    }
    @GetMapping("/getAll")
    public ModelAndView getAll() {
        List<User> users = userService.getAll();
        ModelAndView model = new ModelAndView();
        model.addObject("users",users);
        model.setViewName("users");
        return model;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestBody User user) {
        ModelAndView model = new ModelAndView();
        User verificado = userService.verificarUsuario(user.getUserName(),user.getPassword());
        if (verificado != null) {
            //si entra aca es porque la contraseña y el user name son correctos
            model.setViewName("home");
        } else {
            //Si entra aca es porque algun dato es incorrecto
            model.setViewName("login");
        }

        return model;
    }


}
