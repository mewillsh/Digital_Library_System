package com.example.digitalLibrarySystem.entity;

import com.example.digitalLibrarySystem.entity.Enum.Nationality;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    @Column(name="author_id")
    private Long authorId;
    @NotNull(message = "Name of Author Cannot be Null")
    @Size(max=50)
    private String name;
    @Size(max=350)
    @NotNull(message = "Bio of the Author is Required")
    private String bio;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Nationality Cannot be Null")
    private Nationality nationality;
    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    @JsonManagedReference("author_book")
    private List<Book> books=new ArrayList<>();

    public void saveBook(Book book){
        books.add(book);
        book.setAuthor(this);
    }
    public void removeBook(Book book){
        books.remove(book);
        book.setAuthor(null);
    }
}
