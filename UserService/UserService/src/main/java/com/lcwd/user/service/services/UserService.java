package com.lcwd.user.service.services;

import com.lcwd.user.service.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService  {

    //user operations

    //create
     User saveUser(User user);

     //get all user
    List<User> getAlLUser();

    //get single User of given userId

    User getUser(String userId);


    //TODO:update
    User updateUser(User user);

    //TODO: delete

    String  deleteUser(String userId);




}
