package org.clothify.Service;

import org.clothify.entity.ProductEntity;
import org.clothify.model.Product;

import java.io.File;
import java.util.List;

public interface ProductService {

    Boolean addProduct(File file, Product product);
    Boolean addProduct(Product product);
    List<ProductEntity> getAllProducts();
//    void saveImage(ImageEntity image);
//
//    byte[] getImageById(Long id);
}
