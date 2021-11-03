package com.mahsa.mongolib.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User findUser(User user){
       return userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
    }

    public Optional<User> findUserById(String id){
        return userRepository.findById(id);
    }
}
