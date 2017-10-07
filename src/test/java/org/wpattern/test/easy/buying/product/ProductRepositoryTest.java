package org.wpattern.test.easy.buying.product;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.wpattern.easy.buying.product.Product;
import org.wpattern.easy.buying.product.ProductRepository;
import org.wpattern.easy.buying.product_category.ProductCategoryRepository;
import org.wpattern.easy.buying.utils.BaseEntity;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ProductRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Test
    public void findAll_success() {
        List<Product> productList = productRepository.findAll();

        LOGGER.debug(productList);

        assertNotNull(productList);
        assertTrue(productList.size() > 0);
    }

    @Test
    public void insert() {
        Product product = new Product();
        product.setName("Celular S4");
        product.setDescription("Celular bom de auto porte");
        product.setProductCategory(productCategoryRepository.findOne(1L));
    }
}
