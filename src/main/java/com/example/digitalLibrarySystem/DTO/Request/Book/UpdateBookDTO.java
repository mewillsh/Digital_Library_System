package com.example.digitalLibrarySystem.DTO.Request.Book;

import com.example.digitalLibrarySystem.entity.Enum.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookDTO {
    @NotNull
    private Long id;
    private String name;
    private Long isbn;
    private Category category;
}
