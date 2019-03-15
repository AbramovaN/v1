package com.abramova.blog_cms.controller;

import com.abramova.blog_cms.entity.User;
import com.abramova.blog_cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private Iterable<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    private Optional<User> getOne(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping
    private void add(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        userRepository.save(new User(name, email, password));
    }

    @PutMapping("{id}")
    private void update(@PathVariable Integer id, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user1 = optionalUser.isPresent() ? optionalUser.get() : new User();
        user1.setName(name);
        user1.setEmail(email);
        user1.setPassword(password);
        userRepository.save(user1);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
