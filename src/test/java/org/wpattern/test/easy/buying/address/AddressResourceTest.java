package org.wpattern.test.easy.buying.address;

import org.junit.Test;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wpattern.easy.buying.neighborhood.Neighborhood;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.test.easy.buying.utils.BaseEntityResourceTest;

public class AddressResourceTest extends BaseEntityResourceTest {

    private static final String ADDRES_ID = "Identificador único do endereço.";

    private static final String ADDRESS_NAME = "Nome do endereco.";

    private static final String CEP = "CEP";

    private static final Neighborhood NEIGHBORHOOD = new Neighborhood();

    @Test
    public void findAll_succes() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ResourcePaths.ADDRESS_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                        MockMvcRestDocumentation.document("{method-name",
                                PayloadDocumentation.responseFields(
                                        PayloadDocumentation.fieldWithPath("[].id").description(ADDRES_ID),
                                        PayloadDocumentation.fieldWithPath("[].name").description(ADDRESS_NAME),
                                        PayloadDocumentation.fieldWithPath("[].cep").description(CEP),
                                        PayloadDocumentation.fieldWithPath("[].neighborhood").description(NEIGHBORHOOD)

                                )
                        )
                )
                .andDo(MockMvcResultHandlers.print());
    }

}
