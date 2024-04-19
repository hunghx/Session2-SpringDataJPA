package com.example.jpa.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDtoSuccess<T>{
    private T data;
    private HttpStatus httpStatus;
}
