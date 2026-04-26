package com.example.digitalLibrarySystem.DTO.Request.Book;

import com.example.digitalLibrarySystem.entity.Enum.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookDTO {
    @NotNull
    private Long authID;
    @NotNull
    private String name;
    @NotNull
    private Long isbn;
    @NotNull
    private Category category;
}
