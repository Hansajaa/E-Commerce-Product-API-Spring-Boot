package org.clothify.Service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.clothify.Service.ProductService;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Product;
import org.clothify.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ModelMapper mapper;
    final ProductRepository repository;

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private static final String SERVICE_ACCOUNT_KEY_PATH = getPathToGoogleCredential();

    private static String getPathToGoogleCredential() {
        String currentDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(currentDirectory,"cred.json");
        return filePath.toString();
    }

//    Image upload to Drive location
    public String uploadImageToDrive(File file) {
        try{
            String folderId = "1OSSkAexCOtJuJjFvrHsCOPeim0oU71YP";
            Drive drive = createDriveService();
            com.google.api.services.drive.model.File fileMetaData = new com.google.api.services.drive.model.File();
            fileMetaData.setName(file.getName());
            fileMetaData.setParents(Collections.singletonList(folderId));
            FileContent mediaContent = new FileContent("image/jpeg",file);
            com.google.api.services.drive.model.File uploadedFile = drive.files().create(fileMetaData, mediaContent)
                    .setFields("id").execute();
//            String imageUrl = "https://drive.google.com/uc?exports=view&id="+uploadedFile.getId();
            String imageUrl = "https://drive.google.com/file/d/"+uploadedFile.getId()+"/preview";
            log.info("IMAGE URL: "+imageUrl);
            file.delete();
            return imageUrl;
        }catch (Exception e) {
            log.error(e.getMessage());
            return "Image not Saved";
        }
    }

    private Drive createDriveService() throws IOException, GeneralSecurityException {
        GoogleCredential credentials = GoogleCredential.fromStream(new FileInputStream(SERVICE_ACCOUNT_KEY_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credentials
        ).build();
    }

    @Override
    public ProductEntity addProduct(File file, Product product){
        String imageUrl = uploadImageToDrive(file);
        ProductEntity entity = mapper.map(product, ProductEntity.class);
        entity.setImageUrl(imageUrl);
        return repository.save(entity);
    }

    @Override
    public ProductEntity addProduct(Product product) {
        ProductEntity entity = mapper.map(product, ProductEntity.class);
        return repository.save(entity);

    }

    @Override
    public ProductEntity updateProduct(File file, Product product) {
        String imageUrl = uploadImageToDrive(file);
        ProductEntity entity = mapper.map(product, ProductEntity.class);
        entity.setImageUrl(imageUrl);
        ProductEntity productEntity = repository.save(entity);
        return productEntity;
    }

    @Override
    public ProductEntity updateProduct(Product product) {
        ProductEntity entity = mapper.map(product, ProductEntity.class);
        return repository.save(entity);
    }

    @Override
    public List<ProductEntity> getAllMenProducts() {
        List<ProductEntity> menProducts = repository.findAllByCategory("Men");
        return menProducts;

    }

    @Override
    public List<ProductEntity> getAllWomenProducts() {
        List<ProductEntity> womenProducts = repository.findAllByCategory("Women");
        return womenProducts;
    }

    @Override
    public List<ProductEntity> getAllBabyProducts() {
        List<ProductEntity> babyProducts = repository.findAllByCategory("Baby");
        return babyProducts;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> entityList = repository.findAll();
        return entityList;
    }
}
