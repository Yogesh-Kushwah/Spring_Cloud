package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.model.Hotel;
import com.lcwd.user.service.model.Rating;
import com.lcwd.user.service.model.User;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {

        //generate unique Userid
        String randonUserId = UUID.randomUUID().toString();
        user.setUserId(randonUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAlLUser() {


        List<User> user = userRepository.findAll();
        return user;
    }


    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on the server " + userId));

        // fatching rating of the above user from Rating-Service  - to call  one service from another sevice we need a client
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/user/"+user.getUserId(), Rating[].class);
        logger.info("{}", ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();


        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hote;
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            rating.setHotel(hotel);

            return rating;     }).collect(Collectors.toList());

            user.setRatings(ratingList);

          return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(String userId) {

        userRepository.deleteById(userId);
        return "User get deleted";
    }
}
