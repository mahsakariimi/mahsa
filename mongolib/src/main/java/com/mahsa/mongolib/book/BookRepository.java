package com.mahsa.mongolib.book;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findByNameAndAuthorName(String bookName, String authorName);
}
