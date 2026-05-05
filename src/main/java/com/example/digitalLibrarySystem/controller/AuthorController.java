package com.example.digitalLibrarySystem.controller;

import com.example.digitalLibrarySystem.DTO.Request.Author.CreateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Request.Author.UpdateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Response.Author.AllBooksByAuthor;
import com.example.digitalLibrarySystem.entity.Author;
import com.example.digitalLibrarySystem.service.AuthorService;
import com.example.digitalLibrarySystem.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    AuthorService authorService;
    BookService bookService;
    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody CreateAuthorDTO createAuthorDTO){
        Author curr=authorService.createAuthor(createAuthorDTO);
        return ResponseEntity.status(201).body(curr);
    }
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> curr=authorService.getAuthors();
        return ResponseEntity.ok(curr);
    }
    @PutMapping("/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody UpdateAuthorDTO updateAuthorDTO){
        Author author=authorService.updateAuthor(updateAuthorDTO);
        return ResponseEntity.ok(author);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id){
        Author author=authorService.deleteAuthor(id);
        return ResponseEntity.ok(author);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<AllBooksByAuthor> findAllBookByAuthor(@PathVariable Long id){
        AllBooksByAuthor result=authorService.findAllBooks(id);
        return ResponseEntity.ok(result);
    }
}
