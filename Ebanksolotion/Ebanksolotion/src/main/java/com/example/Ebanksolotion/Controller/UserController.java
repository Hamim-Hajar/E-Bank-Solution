package com.example.Ebanksolotion.Controller;

import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Entity.User;
import com.example.Ebanksolotion.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
UserService userService;
   @GetMapping("/showuser")
      public List<User> getAllUsers() {
        return userService.getAllUsers();
}

    @PostMapping("/add")
    public User addUtilisateur(@RequestBody User user) {
        return userService.addUtilisateur(user.getName(), user.getEmail());
    }
}
