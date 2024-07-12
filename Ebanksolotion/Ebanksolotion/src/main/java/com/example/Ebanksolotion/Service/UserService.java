package com.example.Ebanksolotion.Service;

import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Entity.User;
import com.example.Ebanksolotion.Repository.ComptRepository;
import com.example.Ebanksolotion.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ComptRepository comptRepository;
    @Autowired
    private ComptService comptService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User updateUser(Integer id,User user) {
        User user1 = userRepository.findById(id).orElseThrow(null);
        user1.setFullName(user.getFullName());
        user1.setEmail(user.getEmail());

        return userRepository.save(user1);
    }
    public void deleteUser(int id) {

        userRepository.deleteById(id);

    }


    public User addUtilisateur(String nom, String email) {
        User user = new User();
        user.setFullName(nom);
        user.setEmail(email);

        user = userRepository.save(user);

        Compt compt = comptService.createAccountForUser(user);
        comptRepository.save(compt);

        return user;
    }



}
