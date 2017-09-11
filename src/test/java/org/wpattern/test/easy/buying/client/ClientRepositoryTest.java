package org.wpattern.test.easy.buying.client;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.client.Client;
import org.wpattern.easy.buying.client.ClientRepository;
import org.wpattern.easy.buying.utils.BaseEntity;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import java.util.List;


public class ClientRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void findAll_success() {
        List<Client> clients = clientRepository.findAll();

        LOGGER.debug(clients);

        assertNotNull(clients);
        assertTrue(clients.size() > 0);
    }

    @Ignore
    @Test
    public void insert() {


    }

}
