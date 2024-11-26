package com.rameshsoft.api.service;

import com.rameshsoft.api.dto.UserRequest;
import com.rameshsoft.api.entity.User;
import com.rameshsoft.api.exception.UserNotFoundException;
import com.rameshsoft.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest){
        User user = User.
                build(0,userRequest.getName(), userRequest.getEmail(),
                         userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(),
                         userRequest.getNationality());

        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = repository.findByUserId(id);
        if (user != null){
            return user;
        } else {
            throw new UserNotFoundException("user not found with id: "+id);
        }
    }

}
