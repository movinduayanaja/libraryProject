package com.lib1.backendlib.controller;

import com.lib1.backendlib.model.Book;
import com.lib1.backendlib.repository.BookRepository;

import org.springframework.http.ResponseEntity;
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

    
    @GetMapping("/{id}")
    public Book getOne(@PathVariable Integer id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }


    @PostMapping
    public Book create(@RequestBody Book book) {
        book.setId(null); // ensure create
        return repo.save(book);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
       if (!repo.existsById(id)) {
        return ResponseEntity.notFound().build();
      }
       repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book) {
       if (!repo.existsById(id)) {
        return ResponseEntity.notFound().build();
      }
    // Enforce path ID
       book.setId(id);
       Book saved = repo.save(book);
       return ResponseEntity.ok(saved);
    }


}