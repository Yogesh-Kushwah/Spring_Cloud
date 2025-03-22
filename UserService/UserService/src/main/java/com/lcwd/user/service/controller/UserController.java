package com.lcwd.user.service.controller;

import com.lcwd.user.service.model.User;
import com.lcwd.user.service.payload.ApiResponse;
import com.lcwd.user.service.services.UserService;
import com.lcwd.user.service.services.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private User user;



    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //Create the user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }



    //get single user
    @GetMapping("/{userId}")
//    @Retry(name="ratingRetry",fallbackMethod = "ratingHotelFall")
// @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")

    @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
//        logger.info("Retry count: {}",retryCount);
//        retryCount++;
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    //creating fallback method for circuitbreaker
     public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
      logger.info("fall back executed when the some services are down");

      User user=User.builder()
              .email("Dummy@gmail")
              .name("dummy")
              .about("This is created dummy because some service is down")
            .userId("1234").build();


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
