package com.example.digitalLibrarySystem.entity;

import com.example.digitalLibrarySystem.entity.Enum.Category;
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
    @Column(unique = true)
    private Long isbn;
    @NotNull(message = "Require Category of Book")
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "Authorid")
    private Author author;
}
