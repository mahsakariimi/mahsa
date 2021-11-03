package com.mahsa.mongolib.author;

import com.mahsa.mongolib.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(Wrapper wrapper, String bookId) {
        Author author = authorRepository.findByName(wrapper.author.getName());
        if (author == null) {
            wrapper.author.addBookId(bookId);
            authorRepository.save(wrapper.author);
        } else {
            author.addBookId(bookId);
        }
    }

    public ArrayList<Author> getAllAuthors() {
        return (ArrayList<Author>) authorRepository.findAll();
    }

    public ArrayList<String> getAuthorBooks(String authorName){
        return authorRepository.findByName(authorName).getBooksId();
    }
}

