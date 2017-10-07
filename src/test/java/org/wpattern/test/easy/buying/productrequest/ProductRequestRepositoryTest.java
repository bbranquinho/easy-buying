package org.wpattern.test.easy.buying.productrequest;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.product.ProductRepository;
import org.wpattern.easy.buying.product_category.ProductCategoryRepository;
import org.wpattern.easy.buying.productrequest.ProductRequest;
import org.wpattern.easy.buying.productrequest.ProductRequestRepository;
import org.wpattern.easy.buying.user.UserRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ProductRequestRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private ProductRequestRepository productRequestRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll_success() {
        List<ProductRequest> productRequestList = productRequestRepository.findAll();

        LOGGER.debug(productRequestList);

        assertNotNull(productRequestList);
        assertTrue(productRequestList.size() > 0);
    }

    @Test
    public void insert_sucess() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setDelivery(new Date(2017, 10, 10));
        productRequest.setRequest(new Date(2017, 10, 06));
        productRequest.setDetail("Detalhe da solicitação");
        productRequest.setProduct(productRepository.findOne(1L));
        productRequest.setUser(userRepository.findOne(1L));

        productRequestRepository.save(productRequest);
    }
}
