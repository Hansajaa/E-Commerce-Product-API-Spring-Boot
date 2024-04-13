package org.clothify.Service.impl;

import lombok.RequiredArgsConstructor;
import org.clothify.Service.ProductService;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Product;
import org.clothify.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepository repository;
    final ModelMapper mapper;

    @Override
    public ProductEntity addProduct(Product product) {
        return repository.save(mapper.map(product, ProductEntity.class));
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

//    @Override
//    public void saveImage(ImageEntity image) {
//        repository.save(image);
//    }
//
//    @Override
//    public byte[] getImageById(Long id) {
//        ImageEntity entity = repository.getReferenceById(id);
//        return entity.getData();
//    }
}
