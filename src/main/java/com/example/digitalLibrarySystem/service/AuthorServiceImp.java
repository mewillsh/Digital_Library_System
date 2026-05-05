package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Author.CreateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Request.Author.UpdateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Response.Author.AllBooksByAuthor;
import com.example.digitalLibrarySystem.Repository.AuthorRepository;
import com.example.digitalLibrarySystem.entity.Author;
import com.example.digitalLibrarySystem.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService{
    AuthorRepository repository;
    @Override
    public Author createAuthor(CreateAuthorDTO curr) {
        Author author=new Author(curr.getName(),curr.getBio(),curr.getNationality());
        return repository.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return repository.findAll();
    }

    @Override
    public Author updateAuthor(UpdateAuthorDTO curr) {
        Author author=repository.findById(curr.getId()).orElseThrow(()->new RuntimeException("Author ID is Invalid"));
        if(curr.getName()!=null){
            author.setName(curr.getName());
        }
        if(curr.getBio()!=null){
            author.setBio(curr.getBio());
        }
        if(curr.getNationality()!=null){
            author.setNationality(curr.getNationality());
        }
        return repository.save(author);
    }

    @Override
    public Author deleteAuthor(Long id) {
        Author author=repository.findById(id).orElseThrow(()->new RuntimeException("Author Not Found"));
        repository.deleteById(author.getAuthorid());
        return author;
    }

    @Override
    public AllBooksByAuthor findAllBooks(Long id) {
        Optional<Author>optionalAuthor=repository.findAuthorWithBooks(id);
        AllBooksByAuthor result=new AllBooksByAuthor();
        if(optionalAuthor.isPresent()){
            Author author=optionalAuthor.get();
            List<Book>books=author.getBookId();
            List<String>listBooks=new ArrayList<>();
            for(Book book:books){
                listBooks.add(book.getName());
            }
            result.setAuthor(author.getName());
            result.setBooks(listBooks);
        }
        return result;
    }
}
