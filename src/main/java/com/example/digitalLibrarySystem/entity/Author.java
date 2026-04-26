package com.example.digitalLibrarySystem.entity;

import com.example.digitalLibrarySystem.entity.Enum.Nationality;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long Authorid;
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
    private List<Book> bookId;

    public Author(String name, String bio, Nationality nationality) {
        this.name = name;
        this.bio = bio;
        this.nationality = nationality;
    }
}
