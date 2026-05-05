package com.example.digitalLibrarySystem.controller;

import com.example.digitalLibrarySystem.DTO.Request.Book.BookGetRequest;
import com.example.digitalLibrarySystem.entity.Book;
import com.example.digitalLibrarySystem.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    BookService service;
    @GetMapping
    public ResponseEntity<Page<Book>> findAllBooks(BookGetRequest req){
        Page<Book> ans=service.findAllBooks(req.getPageNo(),req.getCount());
        return ResponseEntity.ok(ans);
    }
}
