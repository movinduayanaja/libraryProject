package com.lib1.backendlib.controller;

import com.lib1.backendlib.model.Book;
import com.lib1.backendlib.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Book> all() {
        return repo.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        book.setId(null); // ensure create
        return repo.save(book);
    }
}