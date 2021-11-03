package com.mahsa.mongolib.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("getauthors")
    public ArrayList<Author> getAuthor() {
        return authorService.getAllAuthors();
    }
    @GetMapping("authorbooks")
    public ArrayList<String> getAuthorBooks(@RequestParam String authorName){
       return authorService.getAuthorBooks(authorName);
    }
}
