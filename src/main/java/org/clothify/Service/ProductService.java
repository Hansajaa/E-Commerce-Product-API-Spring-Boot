package org.clothify.Service;

import org.clothify.entity.ProductEntity;
import org.clothify.model.Product;

import java.io.File;
import java.util.List;

public interface ProductService {

    ProductEntity addProduct(File file, Product product);
    ProductEntity addProduct(Product product);
    ProductEntity updateProduct(File file, Product product);
    ProductEntity updateProduct( Product product);
    Boolean deleteProductById(Long id);
    List<ProductEntity> getAllMenProducts();
    List<ProductEntity> getAllWomenProducts();
    List<ProductEntity> getAllBabyProducts();
    List<ProductEntity> getAllKidsProducts();
    List<ProductEntity> getAllProducts();
    String getNewProductID();
//    void saveImage(ImageEntity image);
//
//    byte[] getImageById(Long id);
}
