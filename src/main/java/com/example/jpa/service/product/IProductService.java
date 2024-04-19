package com.example.jpa.service.product;

import com.example.jpa.exception.DataExistException;
import com.example.jpa.model.dto.request.ProductRequest;
import com.example.jpa.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getALL();
    Product save(ProductRequest productRequest) throws DataExistException;
    Product save(ProductRequest productRequest,Integer id);
    void delete(Integer id);
    Product findById(Integer id);
}
