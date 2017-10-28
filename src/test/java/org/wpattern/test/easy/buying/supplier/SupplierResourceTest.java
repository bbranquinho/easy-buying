package org.wpattern.test.easy.buying.supplier;

import org.junit.Test;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.test.easy.buying.utils.BaseEntityResourceTest;

import java.util.Date;

public class SupplierResourceTest extends BaseEntityResourceTest {

    private static final int ID = 1;

    private static final String NAME = "Nome do Fornecedor";

    private static final String DESCRIPTION = "Descrição do Fornecedor";

    private static final Date REGISTER_DATE = new Date(2017,10,8);

    private static final byte[] LOGO = new byte[100];

    @Test
    public void findAll_success() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ResourcePaths.SUPPLIER_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                        MockMvcRestDocumentation.document("{method-name}",
                                PayloadDocumentation.responseFields(
                                        PayloadDocumentation.fieldWithPath("[].id").description(ID),
                                        PayloadDocumentation.fieldWithPath("[].name").description(NAME),
                                        PayloadDocumentation.fieldWithPath("[].description").description(DESCRIPTION),
                                        PayloadDocumentation.fieldWithPath("[].registerDate").description(REGISTER_DATE),
                                        PayloadDocumentation.fieldWithPath("[].logo").description(LOGO)
                                )
                        )
                )
                .andDo(MockMvcResultHandlers.print());

    }
}
