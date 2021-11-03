package com.mahsa.mongolib.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository  extends MongoRepository<User , String> {
    User findByUserNameAndPassword(String userName , String password);
    //User findById(String id);
}
