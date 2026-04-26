package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Author.CreateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Request.Author.UpdateAuthorDTO;
import com.example.digitalLibrarySystem.Repository.AuthorRepository;
import com.example.digitalLibrarySystem.entity.Author;
import com.example.digitalLibrarySystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public Author deleteAuthor(Long id) {
        return null;
    }

    @Override
    public List<Book> findAllBooks(Long id) {
        return List.of();
    }
}
