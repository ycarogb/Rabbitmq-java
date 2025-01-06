package br.com.ycaro.producer.controllers;

import br.com.ycaro.producer.services.ProductService;
import br.com.ycaro.producer.services.StringService;
import dtos.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> produces(@RequestBody ProductDto dto){
        service.createProduct(dto);
        return ResponseEntity.status(CREATED).build();
    }
}
