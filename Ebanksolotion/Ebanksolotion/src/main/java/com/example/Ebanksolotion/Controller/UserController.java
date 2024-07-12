package com.example.Ebanksolotion.Controller;


import com.example.Ebanksolotion.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import com.example.Ebanksolotion.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
@Autowired
UserService userService;
   @GetMapping("/showuser")
      public List<User> getAllUsers() {
        return userService.getAllUsers();
}

    @PostMapping("/add")
    public User addUtilisateur(@RequestBody User user) {
        return userService.addUtilisateur(user.getFullName(), user.getEmail());
    }
    @PutMapping("/updateuser/{id}")
    public User updateUtilisateur(@PathVariable Integer id, @RequestBody User user) {
       return userService.updateUser(id, user);
    }
    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable Integer id) {
       userService.deleteUser(id);
    }


    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List <User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

}
