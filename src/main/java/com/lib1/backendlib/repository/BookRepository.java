package com.lib1.backendlib.repository;

import com.lib1.backendlib.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> { }
