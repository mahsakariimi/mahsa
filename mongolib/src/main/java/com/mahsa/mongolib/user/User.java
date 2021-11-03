package com.mahsa.mongolib.user;

import com.mahsa.mongolib.book.Book;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    private String userType;

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


