package com.restproj.controller;


import com.restproj.model.Role;
import com.restproj.model.User;
import com.restproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('all')")
    public ResponseEntity<User> delete(@PathVariable Long id){
        userService.delete(userService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
