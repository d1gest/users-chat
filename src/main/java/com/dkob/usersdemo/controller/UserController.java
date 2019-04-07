package com.dkob.usersdemo.controller;

import com.dkob.usersdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> findAll(@RequestParam("page") int page,
                                     @RequestParam("size") int size) {
        return ResponseEntity.ok(userService.finadAllUsers(page, size));
    }
}
