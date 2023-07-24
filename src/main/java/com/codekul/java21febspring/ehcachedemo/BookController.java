package com.codekul.java21febspring.ehcachedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @PostMapping("saveBook")
    public String saveBook(@RequestBody Book book) {
        bookRepo.save(book);
        return "book saved";
    }

    @GetMapping("getAllBook")
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    @PutMapping("updateBook")
    @CachePut(cacheNames = "books", key = "#id")
    public String updateBook(@RequestBody Book book) {
        bookRepo.save(book);
        return "book updated";
    }

    @GetMapping("getBookById/{id}")
    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBookById(@PathVariable("id") Long id) {
        logger.info("from database");
        return bookRepo.getReferenceById(id);
    }

    @DeleteMapping("deleteBookById")
    @CacheEvict(cacheNames = "books", key = "#id")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepo.deleteById(id);
        return "book deleted";
    }
}
