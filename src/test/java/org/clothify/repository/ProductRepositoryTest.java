package org.clothify.repository;

import org.clothify.entity.ProductEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindAllItemsByCategory() {
        //given
        ProductEntity productOne = ProductEntity.builder()
                .productID("P001")
                .name("Shirt")
                .description("White Cotton")
                .quantity(10)
                .price(1200.0)
                .category("MEN")
                .imageUrl("http://sampleImage.png")
                .build();

        ProductEntity productTwo = ProductEntity.builder()
                .productID("P002")
                .name("Frock")
                .description("Blue Cotton")
                .quantity(05)
                .price(1250.0)
                .category("WOMEN")
                .imageUrl("http://sampleImage2.png")
                .build();

        underTest.save(productOne);
        underTest.save(productTwo);

        //when
        List<ProductEntity> result = underTest.findAllByCategory("WOMEN");

        //then
        assertThat(result.get(0)).isEqualTo(productTwo);
    }

    @Test
    void itShouldZeroLengthListWhenNoItemExistsByThatCategory() {

        //when
        List<ProductEntity> result = underTest.findAllByCategory("WOMEN");

        //then
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void itShouldReturnProductIdOfLastItem() {
        //given
        ProductEntity productOne = ProductEntity.builder()
                .productID("P001")
                .name("Shirt")
                .description("White Cotton")
                .quantity(10)
                .price(1200.0)
                .category("MEN")
                .imageUrl("http://sampleImage.png")
                .build();

        ProductEntity productTwo = ProductEntity.builder()
                .productID("P002")
                .name("Frock")
                .description("Blue Cotton")
                .quantity(05)
                .price(1250.0)
                .category("WOMEN")
                .imageUrl("http://sampleImage2.png")
                .build();

        underTest.save(productOne);
        underTest.save(productTwo);

        //when
        String lastId = underTest.findLastId();

        //then
        String expectedLastProductID = "P002";
        assertThat(lastId).isEqualTo(expectedLastProductID);
    }

    @Test
    void itShouldReturnNullWhenNoItemExistsInTheDatabase() {

        //when
        String lastId = underTest.findLastId();

        //then
        assertThat(lastId).isNull();
    }
}