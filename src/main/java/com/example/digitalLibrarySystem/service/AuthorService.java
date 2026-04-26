package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Author.CreateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Request.Author.UpdateAuthorDTO;
import com.example.digitalLibrarySystem.entity.Author;
import com.example.digitalLibrarySystem.entity.Book;

import java.util.List;

public interface AuthorService {
    public Author createAuthor(CreateAuthorDTO curr);
    public List<Author> getAuthors();
    public Author updateAuthor(UpdateAuthorDTO curr);
    public Author deleteAuthor(Long id);
    public List<Book> findAllBooks(Long id);
}
