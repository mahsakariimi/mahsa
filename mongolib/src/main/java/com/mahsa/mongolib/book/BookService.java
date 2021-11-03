package com.mahsa.mongolib.book;

import com.mahsa.mongolib.Wrapper;
import com.mahsa.mongolib.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorService authorService;

    public Book findBook(String bookName, String authorName) {

        return bookRepository.findByNameAndAuthorName(bookName, authorName);
    }

    public String addBook(Wrapper wrapper) {
        wrapper.book.setAuthorName(wrapper.author.getName());
        bookRepository.save(wrapper.book);
        return bookRepository
                .findByNameAndAuthorName(wrapper.book.getName() , wrapper.author.getName())
                .getId();
    }


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


}
