package com.registrationform.controller;

import com.registrationform.entity.UserDto;
import com.registrationform.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserControl {

    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String home() {
        return "index.html";
    }

    @GetMapping("/Register")
    public String register() {
        return "/";
    }

    @GetMapping("/Register/state")
    public String state() {
        return "redirect:/";
    }

    @PostMapping("/api/users")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
