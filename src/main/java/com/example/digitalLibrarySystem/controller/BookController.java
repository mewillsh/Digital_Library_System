package com.example.digitalLibrarySystem.controller;

import com.example.digitalLibrarySystem.DTO.Request.Book.BookGetRequest;
import com.example.digitalLibrarySystem.DTO.Request.Book.CreateBookDTO;
import com.example.digitalLibrarySystem.DTO.Request.Book.UpdateBookDTO;
import com.example.digitalLibrarySystem.entity.Book;
import com.example.digitalLibrarySystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping
    public ResponseEntity<Page<Book>> findAllBooks(@Valid @RequestBody BookGetRequest req){
        Page<Book> ans=bookService.findAllBooks(req.getPageNo(),req.getCount());
        return ResponseEntity.ok(ans);
    }
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody CreateBookDTO createBookDTO){
        Book book=bookService.creatBook(createBookDTO);
        return ResponseEntity.status(201).body(book);
    }
    @PutMapping
    public ResponseEntity<Book> updateBook(@Valid @RequestBody UpdateBookDTO updateBookDTO){
        Book book=bookService.updateBook(updateBookDTO);
        return ResponseEntity.ok(book);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@Valid @PathVariable Long id){
        Book book=bookService.deleteBook(id);
        return ResponseEntity.ok(book);
    }
}
