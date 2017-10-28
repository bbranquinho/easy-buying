package org.wpattern.test.easy.buying.neighborhood;

import org.junit.Test;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wpattern.easy.buying.city.City;
import org.wpattern.easy.buying.state.State;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.test.easy.buying.utils.BaseEntityResourceTest;

public class NeighborhoodResourceTest extends BaseEntityResourceTest {

    private static final int ID = 1;

    private static final String NAME = "Nome do Bairro";

    private static final City CITY = new City();

    @Test
    public void findAll_succes() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ResourcePaths.NEIGHBORHOOD_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                        MockMvcRestDocumentation.document("{method-name}",
                                PayloadDocumentation.responseFields(
                                        PayloadDocumentation.fieldWithPath("[].id").description(ID),
                                        PayloadDocumentation.fieldWithPath("[].name").description(NAME),
                                        PayloadDocumentation.fieldWithPath("[].city").description(CITY)

                                )
                        )
                )
                .andDo(MockMvcResultHandlers.print());
    }
}
