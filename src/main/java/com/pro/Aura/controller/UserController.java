package com.pro.Aura.controller;

import com.pro.Aura.entity.User;
import com.pro.Aura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // این متد برای تسته: همه کاربران رو برمیگردونه
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // این متد برای تسته: یک کاربر جدید میسازه
    @PostMapping
    public User createUser(@RequestBody User user) {
        // در آینده باید رمزعبور رو اینجا هش (Hash) کنیم!
        return userRepository.save(user);
    }
}