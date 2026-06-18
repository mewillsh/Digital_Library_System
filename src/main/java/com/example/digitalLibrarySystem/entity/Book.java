package com.example.digitalLibrarySystem.entity;

import com.example.digitalLibrarySystem.entity.Enum.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Book Name Field Cannot be Null")
    @Size(max=40, message = "Maximum Size is 40 Characters")
    private String name;
    @NotNull(message = "isbn number is Required")
    @Size(min=12,max=12)
    @Column(unique = true, length = 12)
    private String isbn;
    @NotNull(message = "Require Category of Book")
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;
    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;
}
