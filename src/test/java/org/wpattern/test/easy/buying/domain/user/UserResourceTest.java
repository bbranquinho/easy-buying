package org.wpattern.test.easy.buying.domain.user;

import org.junit.Test;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wpattern.easy.buying.address.Address;
import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.supplier.Supplier;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.test.easy.buying.utils.BaseEntityResourceTest;

public class UserResourceTest extends BaseEntityResourceTest {

    private static final String USER_ID = "Identificador único do usuário.";

    private static final String USER_NAME = "Nome do usuário.";

    private static final String LAST_NAME = "Sobre nome";

    private static final String EMAIL = "Email do usuário";

    private static final String PASSWORD = "Senha do usuário";

    private static final String PHONE = "34991393623";

    private static final byte[] PHOTO = new byte[100];

    private static final String ADDRESS_COMPLEMENT = "Complemento do Endereço";

    private static final String ADDRESS_NUMBER = "Numero da Casa";

    private static final String ADDRESS_REFERENCE = "Referencia da casa";

    private static final Permission PERMISSION_ENTITY = new Permission();

    private static final Address ADDRESS_ID = new Address();

    private static final Supplier SUPPLIERS = new Supplier();


    @Test
    public void findAll_success() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ResourcePaths.USER_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                        MockMvcRestDocumentation.document("{method-name}",
                                PayloadDocumentation.responseFields(
                                        PayloadDocumentation.fieldWithPath("[].id").description(USER_ID),
                                        PayloadDocumentation.fieldWithPath("[].name").description(USER_NAME),
                                        PayloadDocumentation.fieldWithPath("[].sobreNome").description(LAST_NAME),
                                        PayloadDocumentation.fieldWithPath("[].email").description(EMAIL),
                                        PayloadDocumentation.fieldWithPath("[].password").description(PASSWORD),
                                        PayloadDocumentation.fieldWithPath("[].phone").description(PHONE),
                                        PayloadDocumentation.fieldWithPath("[].photo").description(PHOTO),
                                        PayloadDocumentation.fieldWithPath("[].complemento").description(ADDRESS_COMPLEMENT),
                                        PayloadDocumentation.fieldWithPath("[].numero").description(ADDRESS_NUMBER),
                                        PayloadDocumentation.fieldWithPath("[].referencia").description(ADDRESS_REFERENCE),
                                        PayloadDocumentation.fieldWithPath("[].address").description(ADDRESS_ID),
                                        PayloadDocumentation.fieldWithPath("[].permissions").description(PERMISSION_ENTITY),
                                        PayloadDocumentation.fieldWithPath("[].suppliers").description(SUPPLIERS)

                                )
                        )
                )
                .andDo(MockMvcResultHandlers.print());

    }

}
