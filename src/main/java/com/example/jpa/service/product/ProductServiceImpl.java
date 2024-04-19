package com.example.jpa.service.product;

import com.example.jpa.exception.DataExistException;
import com.example.jpa.model.dto.request.ProductRequest;
import com.example.jpa.model.entity.Product;
import com.example.jpa.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Product> getALL() {
        return productRepository.findAll();
    }

    @Override
    public Product save(ProductRequest productRequest) throws DataExistException{
        Product product = mapper.map(productRequest, Product.class);
        if (productRepository.existsByName(productRequest.getName())){
            throw new DataExistException("product nam ist exist","name");
        }
        return productRepository.save(product);
    }

    @Override
    public Product save(ProductRequest productRequest, Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ko ton tai id"));
        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ko ton tai id"));
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ko ton tai id"));
    }
}
