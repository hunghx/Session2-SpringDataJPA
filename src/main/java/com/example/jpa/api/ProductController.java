package com.example.jpa.api;

import com.example.jpa.exception.DataExistException;
import com.example.jpa.model.dto.request.ProductRequest;
import com.example.jpa.model.dto.response.ResponseDtoSuccess;
import com.example.jpa.service.product.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api.example.com/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    // get all
    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(new ResponseDtoSuccess(productService.getALL(), HttpStatus.OK), HttpStatus.OK);
    }

    // thêm mới
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody ProductRequest productRequest) throws DataExistException {
        return new ResponseEntity<>(new ResponseDtoSuccess<>(productService.save(productRequest), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody ProductRequest productRequest, @PathVariable Integer id) {
        return new ResponseEntity<>(new ResponseDtoSuccess<>(productService.save(productRequest, id), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(new ResponseDtoSuccess<>(productService.findById(id), HttpStatus.OK), HttpStatus.OK);
    }

}
