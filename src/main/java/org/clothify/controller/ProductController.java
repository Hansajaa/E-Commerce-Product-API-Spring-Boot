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
@CrossOrigin
public class ProductController {

    final ProductService service;

    @PostMapping("/add")
    public ProductEntity addProduct(@RequestParam("file") MultipartFile file, @ModelAttribute Product product) throws IOException {

        if (file.isEmpty()){
            return service.addProduct(product);
        }

        File tempFile = File.createTempFile("temp",null);
        file.transferTo(tempFile);

        product.setProductID(service.getNewProductID());

        return service.addProduct(tempFile,product);
    }

    @PutMapping("/put")
    public ProductEntity updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteById/{id}")
    public Boolean deleteProduct(@PathVariable Long id){
        return service.deleteProductById(id);
    }


    @GetMapping("get-all")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    @GetMapping("/getProducts/men")
    public List<ProductEntity> getAllMenProducts(){
        return service.getAllMenProducts();
    }

    @GetMapping("/getProducts/women")
    public List<ProductEntity> getAllWomenProducts(){
        return service.getAllWomenProducts();
    }

    @GetMapping("/getProducts/baby")
    public List<ProductEntity> getAllBabyProducts(){
        return service.getAllBabyProducts();
    }

    @GetMapping("/getProducts/kids")
    public List<ProductEntity> getAllKidsProducts(){
        return service.getAllKidsProducts();
    }

    @GetMapping("/getNewProductID")
    public String getNewProductID(){
        return service.getNewProductID();
    }
}
