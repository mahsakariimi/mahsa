package com.mahsa.mongolib.author;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Author {
    @Id
    private String id;
    @JsonProperty("author-name")
    private String name;
    private ArrayList<String> booksId ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getBooksId() {
        return booksId;
    }

    public void addBookId(String bookId) {
        booksId.add(bookId);
    }

    public Author() {
        booksId = new ArrayList<String>();
    }
}

