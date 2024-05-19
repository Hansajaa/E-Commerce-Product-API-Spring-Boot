package org.clothify.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.clothify.Service.ProductService;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    final ProductService service;

    @PostMapping("/add")
    public Boolean addProduct(@RequestParam("file") MultipartFile file, @ModelAttribute Product product) throws IOException {

        if (file.isEmpty()){
            return service.addProduct(product);
        }

        File tempFile = File.createTempFile("temp",null);
        file.transferTo(tempFile);

        return service.addProduct(tempFile,product);
    }


    @GetMapping("get-all")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        return ResponseEntity.ok().body(service.getAllProducts());
    }

}
