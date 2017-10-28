package org.wpattern.test.easy.buying.city;

import org.junit.Test;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wpattern.easy.buying.state.State;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.test.easy.buying.utils.BaseEntityResourceTest;

public class CityResourceTest extends BaseEntityResourceTest {

    private static final int ID = 1;

    private static final String NAME = "Nome do cidade";

    private static final State STATE = new State();


    @Test
    public void findAll_succes() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ResourcePaths.CITY_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                        MockMvcRestDocumentation.document("{method-name}",
                                PayloadDocumentation.responseFields(
                                        PayloadDocumentation.fieldWithPath("[].id").description(ID),
                                        PayloadDocumentation.fieldWithPath("[].name").description(NAME),
                                        PayloadDocumentation.fieldWithPath("[].state").description(STATE)

                                )
                        )
                )
                .andDo(MockMvcResultHandlers.print());
    }

}
