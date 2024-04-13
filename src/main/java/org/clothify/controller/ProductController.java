package org.clothify.controller;

import lombok.RequiredArgsConstructor;
import org.clothify.Service.ProductService;
import org.clothify.entity.ImageEntity;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    final ProductService service;

    @PostMapping("/add")
    public ResponseEntity<ProductEntity> addProduct(@RequestPart("product") Product product,
                                                    @RequestPart("productImage") MultipartFile[] file){

        try {
            Set<ImageEntity> uploadImages = uploadImages(file);
            product.setImages(uploadImages);
            ProductEntity productEntity = service.addProduct(product);
            return ResponseEntity.ok().body(productEntity);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }

    }

    public Set<ImageEntity> uploadImages(MultipartFile[] multipartFiles)throws IOException {
        Set<ImageEntity> images = new HashSet<>();

        for (MultipartFile file:multipartFiles) {
            ImageEntity entity=new ImageEntity(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            images.add(entity);
        }

        return images;
    }



    @GetMapping("get-all")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        return ResponseEntity.ok().body(service.getAllProducts());
    }

}
