package org.clothify.controller;

import lombok.RequiredArgsConstructor;
import org.clothify.Service.ProductService;
import org.clothify.entity.ImageEntity;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    final ProductService service;

    @PostMapping("/add")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody Product product){
        ProductEntity productEntity = service.addProduct(product);
        return ResponseEntity.ok().body(productEntity);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        return ResponseEntity.ok().body(service.getAllProducts());
    }


//    @PostMapping("img/upload")
//    public Boolean uploadImage(@RequestBody MultipartFile file) throws IOException {
//        ImageEntity image=new ImageEntity();
//        image.setName(file.getOriginalFilename());
//        image.setData(file.getBytes());
//
//        service.saveImage(image);
//        return true;
//    }
//
//    @GetMapping(value = "/get-img/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public ResponseEntity getImageById(@PathVariable Long id){
//        byte[] imageById = service.getImageById(id);
//        return ResponseEntity.ok().body(imageById);
//    }
}
