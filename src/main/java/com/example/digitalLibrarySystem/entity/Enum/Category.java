package com.example.digitalLibrarySystem.entity.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    Mystery,
    Thriller,
    Romance,
    Fantasy,
    Science,
    Fiction,
    Horror,
    Adventure;
    @JsonCreator
    public static Category form(String val){
        try{
            return Category.valueOf(val);
        }
        catch(Exception e){
            throw new IllegalArgumentException("This Category is Invalid");
        }
    }
}
