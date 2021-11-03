package com.mahsa.mongolib.rentBook;

import com.mahsa.mongolib.Wrapper;
import com.mahsa.mongolib.book.Book;
import com.mahsa.mongolib.user.User;
import org.springframework.data.annotation.Id;

public class RentBook {
    @Id
    private String id;
    private String rentDate;
    private Book book;
    private User user;

    public String getId() {
        return id;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
