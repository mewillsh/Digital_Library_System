package com.example.digitalLibrarySystem.service;

import com.example.digitalLibrarySystem.DTO.Request.Author.CreateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Request.Author.UpdateAuthorDTO;
import com.example.digitalLibrarySystem.DTO.Request.Book.CreateBookDTOHelper;
import com.example.digitalLibrarySystem.DTO.Response.Author.AllBooksByAuthor;
import com.example.digitalLibrarySystem.Repository.AuthorRepository;
import com.example.digitalLibrarySystem.entity.Author;
import com.example.digitalLibrarySystem.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService{
    @Autowired
    AuthorRepository repository;
    @Override
    public Author createAuthor(CreateAuthorDTO curr) {
        Author author=dtoTOAuthor(curr);
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
        repository.deleteById(author.getAuthorId());
        return author;
    }

    @Override
    public AllBooksByAuthor findAllBooks(Long id) {
        Optional<Author>optionalAuthor=repository.findAuthorWithBooks(id);
        AllBooksByAuthor result=new AllBooksByAuthor();
        if(optionalAuthor.isPresent()){
            Author author=optionalAuthor.get();
            List<Book>books=author.getBooks();
            List<String>listBooks=new ArrayList<>();
            for(Book book:books){
                listBooks.add(book.getName());
            }
            result.setAuthor(author.getName());
            result.setBooks(listBooks);
        }
        return result;
    }
    public Author dtoTOAuthor(CreateAuthorDTO createAuthors){
        Author author=new Author();
        author.setName(createAuthors.getName());
        author.setBio(createAuthors.getBio());
        author.setNationality(createAuthors.getNationality());
        List<Book>curr=new ArrayList<>();
        for(CreateBookDTOHelper now:createAuthors.getAuthorDTOList()){
            Book temp=dtoToBook(now);
            temp.setAuthor(author);
            curr.add(temp);
        }
        author.setBooks(curr);
        return author;
    }
    public Book dtoToBook(CreateBookDTOHelper createBook){
        Book book=new Book();
        book.setName(createBook.getName());
        book.setIsbn(createBook.getIsbn());
        book.setCategory(createBook.getCategory());
        return book;
    }
}
