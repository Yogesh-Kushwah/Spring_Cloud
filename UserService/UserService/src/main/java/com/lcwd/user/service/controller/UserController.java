package com.lcwd.user.service.controller;

import com.lcwd.user.service.model.User;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create the user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }

    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //get all the users
    @GetMapping
    public ResponseEntity<List<User>> getAllUSer() {
        List<User> allUsers = userService.getAlLUser();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

      //update User
      @PutMapping
      public ResponseEntity<User> updateUser(@RequestBody User user){

        User user1= userService.updateUser(user);
        return  new ResponseEntity<>(user1,HttpStatus.OK);

        }

        @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        String user= userService.deleteUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
        }

}
