package com.example.jpa.model.dto.request;

import com.example.jpa.validation.ProductNotExist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {
    @NotBlank
//    @ProductNotExist
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer stock;
    @Size(max = 100)
    private String description;
}
