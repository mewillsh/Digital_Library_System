package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Book.CreateBookDTO;
import com.example.digitalLibrarySystem.DTO.Request.Book.UpdateBookDTO;
import com.example.digitalLibrarySystem.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    public Page<Book> findAllBooks(int size, int number);
    public Book creatBook(CreateBookDTO curr);
    public Book updateBook(UpdateBookDTO curr);
    public Book deleteBook(Long id);
}
