package com.mahsa.mongolib.user;

import com.mahsa.mongolib.book.Response;
import com.mahsa.mongolib.util.Util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("createuser")
    public String createUser(@RequestBody User user){
        userService.addUser(user);
        return "User created successfully";
    }

    @PostMapping("login")
    public Response login(@RequestBody User user) {
        User u  =userService.findUser(user);
        Util util = new Util();
        if (u != null) {
            String payload = String.format("{\"message\" : %s }", u.getId());
            String token = Jwts.builder()
                    .setPayload(payload)
                    .signWith(SignatureAlgorithm.HS256,util.getSecret())
                    .compact();
            return new Response("ok", token + "");
        } else {
            return new Response("not found");
        }
    }

}
