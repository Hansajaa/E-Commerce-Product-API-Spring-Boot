package org.clothify.Service;

import org.clothify.entity.ImageEntity;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Image;
import org.clothify.model.Product;

import java.util.List;

public interface ProductService {

    ProductEntity addProduct(Product product);
    List<ProductEntity> getAllProducts();
//    void saveImage(ImageEntity image);
//
//    byte[] getImageById(Long id);
}
