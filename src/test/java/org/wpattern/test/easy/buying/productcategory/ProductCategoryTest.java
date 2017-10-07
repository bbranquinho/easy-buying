package org.wpattern.test.easy.buying.productcategory;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.product_category.ProductCategory;
import org.wpattern.easy.buying.product_category.ProductCategoryRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ProductCategoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Test
    public void findAll_success() {
        List<ProductCategory> categoryList = productCategoryRepository.findAll();

        LOGGER.debug(categoryList);

        assertNotNull(categoryList);
        assertTrue(categoryList.size() > 0);
    }

    @Test
    public void insert() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Roupas e Acessorios");
        productCategoryRepository.save(productCategory);
    }
}
