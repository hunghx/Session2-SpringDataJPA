package com.example.jpa.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {
    private static final DateTimeConverter dateTimeConverter = new DateTimeConverter() ;
    private DateTimeConverter(){

    }
    public static DateTimeConverter getInstance(){
        return dateTimeConverter;
    }
    public LocalDate convertToLocalDate(String time){
        // yyyy-MM-dd
        return LocalDate.parse(time, DateTimeFormatter.ISO_DATE);
    }
}
