package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Author.CreateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Request.Author.UpdateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Response.Author.AllBooksByAuthor;
import com.example.digitalLibrarySystem.entity.Author;
import com.example.digitalLibrarySystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthorService {
    public Author createAuthor(CreateAuthorDTO curr);
    public List<Author> getAuthors();
    public Author updateAuthor(UpdateAuthorDTO curr);
    public Author deleteAuthor(Long id);
    public AllBooksByAuthor findAllBooks(Long id);
}
