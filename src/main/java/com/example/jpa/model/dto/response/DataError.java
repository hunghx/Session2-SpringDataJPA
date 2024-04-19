package com.example.jpa.model.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataError <T> {
    private T messages;
//    private int statusCode;
    private HttpStatus httpStatus;
}

