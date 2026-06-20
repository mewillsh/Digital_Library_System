package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Book.CreateBookDTO;
import com.example.digitalLibrarySystem.DTO.Request.Book.UpdateBookDTO;
import com.example.digitalLibrarySystem.Repository.AuthorRepository;
import com.example.digitalLibrarySystem.Repository.BookRepository;
import com.example.digitalLibrarySystem.Repository.PublisherRepository;
import com.example.digitalLibrarySystem.entity.Author;
import com.example.digitalLibrarySystem.entity.Book;
import com.example.digitalLibrarySystem.entity.Publisher;
import com.example.digitalLibrarySystem.exception.AuthorNotFoundException;
import com.example.digitalLibrarySystem.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService{
    @Autowired
    BookRepository repository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Override
    public Page<Book> findAllBooks(int pageNo, int count) {
        Pageable page= PageRequest.of(pageNo, count);
        return repository.findAll(page);
    }

    @Override
    public Book creatBook(CreateBookDTO curr) {
        Author author=authorRepository.findByName(curr.getAuthor()).orElseGet(
                ()->{
                    Author a=new Author();
                    a.setName(curr.getAuthor());
                    a.setNationality(curr.getAuthorNationality());
                    a.setBio(curr.getAuthorBio());
                    return authorRepository.save(a);
                }
        );
        Publisher publisher=publisherRepository.findByName(curr.getPublisher()).orElseGet(
                ()->{
                    Publisher p=new Publisher();
                    p.setName(curr.getPublisher());
                    p.setAddress(curr.getPublisherAddress());
                    return publisherRepository.save(p);
                }
        );
        Book book=new Book();
        book.setName(curr.getName());
        book.setIsbn(curr.getIsbn());
        book.setCategory(curr.getCategory());
        author.saveBook(book);
        publisher.saveBook(book);
        return repository.save(book);
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
            book.setCategory(curr.getCategory());
        }
        repository.save(book);
        return book;
    }

    @Override
    public Book deleteBook(Long id) {
        Book book=repository.findById(id).orElseThrow(()->new RuntimeException("Book is Already Deleted"));
        Author author=authorRepository.findById(book.getAuthor().getAuthorId()).orElseThrow(
                ()->new AuthorNotFoundException("Author is not Available"));
        Publisher publisher=publisherRepository.findById(book.getPublisher().getId()).orElseThrow(
                ()->new RuntimeException("Publisher is Not Avaliable")
        );
        author.removeBook(book);
        publisher.removeBook(book);
        repository.deleteById(id);
        return book;
    }

    @Override
    public Book findBook(Long id) {
        return repository.findById(id).orElseThrow(()->new BookNotFoundException("Requested Book is not Available"));
    }

}
