package com.micro.productservice.service;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.productservice.dto.ProductRequest;
import com.micro.productservice.model.Product;
import com.micro.productservice.repository.ProductRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    // @Autowired
    private final ProductRepo productRepo;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

        productRepo.save(product);
        log.info("Produt {} is saved", product.getId());
    }
}
