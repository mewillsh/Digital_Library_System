package com.example.digitalLibrarySystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "jpa_distributor")
public class Publisher {
    @Id
    @GeneratedValue
    private int id;
    private String address;
    private String name;
    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    private List<Book> bookList;

    public void saveBook(Book book){
        bookList.add(book);
        book.setPublisher(this);
    }
    public void removeBook(Book book){
        bookList.remove(book);
        book.setPublisher(this);
    }
}
