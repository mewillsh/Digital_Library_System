package com.example.digitalLibrarySystem.DTO.Request.Author;

import com.example.digitalLibrarySystem.entity.Enum.Nationality;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAuthorDTO {
    @NotNull(message = "Author ID is Required")
    private Long id;
    private String name;
    private String bio;
    private Nationality nationality;
}
