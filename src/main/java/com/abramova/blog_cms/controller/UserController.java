package com.abramova.blog_cms.controller;

import com.abramova.blog_cms.entity.User;
import com.abramova.blog_cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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
    private Optional<User> list(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping
    private void add(@RequestBody Map<String, String> user) {
        userRepository.save(new User(user.get("name"), user.get("email"), user.get("password")));
    }

    @PutMapping("{id}")
    private void update(@PathVariable Integer id, @RequestBody Map<String, String> user) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user1 = optionalUser.isPresent() ? optionalUser.get() : new User();
        user1.setName(user.get("name"));
        user1.setEmail(user.get("email"));
        user1.setPassword(user.get("password"));
        userRepository.save(user1);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
