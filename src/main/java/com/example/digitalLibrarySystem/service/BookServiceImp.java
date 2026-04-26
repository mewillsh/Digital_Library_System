package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Book.CreateBookDTO;
import com.example.digitalLibrarySystem.DTO.Request.Book.UpdateBookDTO;
import com.example.digitalLibrarySystem.Repository.BookRepository;
import com.example.digitalLibrarySystem.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService{
    BookRepository repository;
    @Override
    public Page<Book> findAllBooks(int pageNo, int count) {
        Pageable page= PageRequest.of(pageNo, count);
        return repository.findAll(page);
    }

    @Override
    public Book creatBook(CreateBookDTO curr) {
        return null;
    }

    @Override
    public Book updateBook(UpdateBookDTO curr) {
        return null;
    }

    @Override
    public Book deleteBook(Long id) {
        return null;
    }
}
