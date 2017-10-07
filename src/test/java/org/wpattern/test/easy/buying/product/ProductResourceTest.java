package org.wpattern.test.easy.buying.product;

import org.junit.Test;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wpattern.easy.buying.product_category.ProductCategory;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.test.easy.buying.utils.BaseEntityResourceTest;

public class ProductResourceTest extends BaseEntityResourceTest {

    private static final int ID = 1;

    private static final String NAME = "Nome do Produto";

    private static final String DESCRIPTION = "Descricao do Produto";

    private static final ProductCategory PRODUCT_CATEGORY  = new ProductCategory();

    @Test
    public void findAll_succes() throws  Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ResourcePaths.PRODUCT_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                        MockMvcRestDocumentation.document("{method-name",
                                PayloadDocumentation.responseFields(
                                        PayloadDocumentation.fieldWithPath("[].id").description(ID),
                                        PayloadDocumentation.fieldWithPath("[].name").description(NAME),
                                        PayloadDocumentation.fieldWithPath("[].description").description(DESCRIPTION),
                                        PayloadDocumentation.fieldWithPath("[].productCategory").description(PRODUCT_CATEGORY)
                                )
                        )
                )
                .andDo(MockMvcResultHandlers.print());
    }
}
