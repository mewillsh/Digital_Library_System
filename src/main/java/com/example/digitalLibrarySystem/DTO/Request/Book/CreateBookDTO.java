package com.example.digitalLibrarySystem.DTO.Request.Book;

import com.example.digitalLibrarySystem.entity.Enum.Category;
import com.example.digitalLibrarySystem.entity.Enum.Nationality;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookDTO {
    @NotNull
    private String author;
    @NotNull
    private String authorBio;
    @NotNull
    private Nationality authorNationality;
    @NotNull
    private String publisher;
    @NotNull
    private String publisherAddress;
    @NotNull
    private String name;
    @NotNull
    private String isbn;
    @NotNull
    private Category category;
}
