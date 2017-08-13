package org.wpattern.test.easy.buying.domain.user;

import org.junit.Test;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.test.easy.buying.utils.BaseResourceTest;

public class UserResourceTest extends BaseResourceTest {

    @Test
    public void findAll_success() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ResourcePaths.USER_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document("{method-name}"));

    }

}
