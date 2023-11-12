package com.example.saqayaCoderbyteProject.controller;


import com.example.saqayaCoderbyteProject.config.JwtService;
import com.example.saqayaCoderbyteProject.model.User;
import com.example.saqayaCoderbyteProject.model.UserVTO;
import com.example.saqayaCoderbyteProject.service.MapperService;
import com.example.saqayaCoderbyteProject.service.UserService;
import com.example.saqayaCoderbyteProject.model.CustomResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Log4j2
public class UsersController {

    private UserService userService;
    private JwtService jwtService;

    @PostMapping("/users")
    public ResponseEntity<CustomResponse> addUser(@RequestBody User user){
        User userAfterId = userService.generateUserId(user);
        User userReturned = userService.saveUser(userAfterId);
        String token= jwtService.generateToken(userReturned);

        CustomResponse customResponse = new CustomResponse(userReturned.getId(), token);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserVTO> getUserById(@PathVariable String id){
        Optional<User> userData = Optional.ofNullable(userService.getUserById(id));
        UserVTO vto = MapperService.mapToCustomVTO(userData);
        return userData.map(user -> new ResponseEntity<>(vto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
