package com.mahsa.mongolib.book;

import com.mahsa.mongolib.Wrapper;
import com.mahsa.mongolib.author.AuthorService;
import com.mahsa.mongolib.rentBook.RentBook;
import com.mahsa.mongolib.rentBook.RentService;
import com.mahsa.mongolib.user.User;
import com.mahsa.mongolib.user.UserService;
import com.mahsa.mongolib.util.Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
public class BookController {
    @Autowired
    RentService rentService;
    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Autowired
    UserService userService;

    @PostMapping("insert-book")
    public String addNewBook(@RequestBody Wrapper wrapper) {
        Book book = bookService.findBook(wrapper.book.getName(), wrapper.author.getName());
        if (book == null) {

            String bookId = bookService.addBook(wrapper);
            authorService.addAuthor(wrapper, bookId);
            return "Book added successfully";
        } else {
            return "This book already exists";
        }
    }

    @GetMapping("get-books")
    public List<Book> getallbooks() {
        return bookService.getBooks();
    }

    @PostMapping("bookrental")
    public String rent(@RequestBody Wrapper wrapper, @RequestHeader String authorization) {
        try {
            Util util = new Util();
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(util.getSecret()).parseClaimsJws(authorization);
            String id = (String) claimsJws.getBody().get("message");
            System.out.println(id);
            User user = userService.findUserById(id).get();
            Book book = bookService.findBook(wrapper.book.getName(), wrapper.author.getName());
            RentBook rentBook = new RentBook();
            if (user != null) {
                if (book.getIsAvailable() == true) {
                    book.setAvailable(false);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/mm/dd hh:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String currentDate = dtf.format(now);
                    rentBook.setRentDate(currentDate);
                    rentBook.setUser(user);
                    rentBook.setBook(book);
                    rentService.saveRent(rentBook);
                }
            }
            return user.getUserName() + "rent the " + book.getName();
        } catch (SignatureException e) {
            return "token is not valid";
        }
    }

}

