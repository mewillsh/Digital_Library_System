package com.example.digitalLibrarySystem.DTO.Response.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllBooksByAuthor {
    String Author;
    List<String> Books;
}
