package com.example.digitalLibrarySystem.entity.Enum;

import com.fasterxml.jackson.annotation.JsonInclude;

public enum Nationality {
    INDIAN,
    AMERICAN,
    BRITISH,
    CANADIAN,
    AUSTRALIAN,
    GERMAN,
    FRENCH,
    ITALIAN,
    JAPANESE,
    CHINESE,
    SOUTH_KOREAN,
    RUSSIAN,
    BRAZILIAN,
    MEXICAN,
    SOUTH_AFRICAN,
    SPANISH,
    DUTCH,
    SWISS,
    SINGAPOREAN,
    NEW_ZEALANDER;

    @JsonInclude
    public static Nationality field(String val){
        try{
            return Nationality.valueOf(val.toUpperCase());
        }
        catch (Exception e){
            throw new IllegalArgumentException("This Nationality is Not Valid");
        }
    }
}
