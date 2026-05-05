package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Book.CreateBookDTO;
import com.example.digitalLibrarySystem.DTO.Request.Book.UpdateBookDTO;
import com.example.digitalLibrarySystem.Repository.AuthorRepository;
import com.example.digitalLibrarySystem.Repository.BookRepository;
import com.example.digitalLibrarySystem.entity.Author;
import com.example.digitalLibrarySystem.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService{
    BookRepository repository;
    AuthorRepository repository2;
    @Override
    public Page<Book> findAllBooks(int pageNo, int count) {
        Pageable page= PageRequest.of(pageNo, count);
        return repository.findAll(page);
    }

    @Override
    public Book creatBook(CreateBookDTO curr) {
        Author author=repository2.findById(curr.getAuthID()).orElseThrow(()->new RuntimeException("Book Author is Not Available"));
        Book book=new Book(curr.getName(),curr.getIsbn(),curr.getCategory(),author);
        repository.save(book);
        return book;
    }

    @Override
    public Book updateBook(UpdateBookDTO curr) {
        Book book=repository.findById(curr.getId()).orElseThrow(()->new RuntimeException("Requested Book is Not Available"));
        if(curr.getName()!=null){
            book.setName(curr.getName());
        }
        if(curr.getIsbn()!=null){
            book.setIsbn(curr.getIsbn());
        }
        if(curr.getCategory()!=null){
            book.setIsbn(curr.getIsbn());
        }
        repository.save(book);
        return book;
    }

    @Override
    public Book deleteBook(Long id) {
        Book book=repository.findById(id).orElseThrow(()->new RuntimeException("Book is Already Deleted"));
        repository.deleteById(id);
        return book;
    }

}
