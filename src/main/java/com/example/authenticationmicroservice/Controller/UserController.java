package com.example.authenticationmicroservice.Controller;

import com.example.authenticationmicroservice.Entity.User;
import com.example.authenticationmicroservice.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    /**
     * get all users
     * @return users
     */
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> findALl() {
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }




}
