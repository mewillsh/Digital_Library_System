package com.example.digitalLibrarySystem.DTO.Request.Book;

import com.example.digitalLibrarySystem.entity.Enum.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookDTOHelper {
    @NotNull
    private String name;
    @NotNull
    private String isbn;
    @NotNull
    private Category category;
}
