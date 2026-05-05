package com.example.digitalLibrarySystem.DTO.Request.Book;

import lombok.Data;

@Data
public class BookGetRequest {
    private int pageNo;
    private int count;
}
