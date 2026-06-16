package com.example.digitalLibrarySystem.DTO.Request.Author;

import com.example.digitalLibrarySystem.DTO.Request.Book.CreateBookDTOHelper;
import com.example.digitalLibrarySystem.entity.Enum.Nationality;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorDTO {
    @NotNull
    private String name;
    @NotNull
    private String bio;
    @NotNull
    private Nationality nationality;
    private List<CreateBookDTOHelper> authorDTOList;
}
