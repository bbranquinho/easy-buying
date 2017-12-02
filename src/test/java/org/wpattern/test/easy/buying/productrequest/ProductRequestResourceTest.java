package org.wpattern.test.easy.buying.productrequest;

import org.junit.Test;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wpattern.easy.buying.product.Product;
import org.wpattern.easy.buying.supplier.Supplier;
import org.wpattern.easy.buying.user.User;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.test.easy.buying.utils.BaseEntityResourceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductRequestResourceTest extends BaseEntityResourceTest {

    private static final int ID = 1;

    private static final Product PRODUCT = new Product();

    private static final User USER = new User();

    private static final String DETAIL = "Detalhe da Requisicao";

    private static final Date DELIVERY = new Date(2017, 10, 10);

    private static final Date REQUEST = new Date(2017, 10, 06);


    @Test
    public void findAll_succes() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ResourcePaths.PRODUCT_REQUEST_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                        MockMvcRestDocumentation.document("{method-name}",
                                PayloadDocumentation.responseFields(
                                        PayloadDocumentation.fieldWithPath("[].id").description(ID),
                                        PayloadDocumentation.fieldWithPath("[].product").description(PRODUCT),
                                        PayloadDocumentation.fieldWithPath("[].user").description(USER),
                                        PayloadDocumentation.fieldWithPath("[].detail").description(DETAIL),
                                        PayloadDocumentation.fieldWithPath("[].delivery").description(DELIVERY),
                                        PayloadDocumentation.fieldWithPath("[].request").description(REQUEST)


                                )
                        )
                )
                .andDo(MockMvcResultHandlers.print());
    }

}
