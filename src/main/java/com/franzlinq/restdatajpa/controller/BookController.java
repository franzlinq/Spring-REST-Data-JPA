package com.franzlinq.restdatajpa.controller;

import com.franzlinq.restdatajpa.entities.Book;
import com.franzlinq.restdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    final private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE

    // GET
    // GET ALL
    @GetMapping("/api/books")
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    // GET ONE BY ID
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);

        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //POST
    @PostMapping("/api/books")
    public Book createBook(@RequestBody Book book, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        return bookRepository.save(book);
    }

    // DELETE
}
