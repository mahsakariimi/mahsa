package com.mahsa.mongolib.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private String id;
    @JsonProperty("book-name")
    private String name;
    private String authorName;
    private boolean isAvailable = true ;

    public boolean getIsAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
}
