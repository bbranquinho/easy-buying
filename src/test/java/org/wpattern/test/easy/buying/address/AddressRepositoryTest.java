package org.wpattern.test.easy.buying.address;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.address.Address;
import org.wpattern.easy.buying.address.AddressRepository;
import org.wpattern.easy.buying.neighborhood.NeighborhoodRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class AddressRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Test
    public void findAll_success() {
        List<Address> addressList = addressRepository.findAll();

        LOGGER.debug(addressList);

        assertNotNull(addressList);
        assertTrue(addressList.size() > 0);
    }

    @Test
    public void insert() {
        Address address = new Address();
        address.setName("Rua iolanda Alves Figueira");
        address.setCep("38414650");
        address.setNeighborhood(neighborhoodRepository.findOne(1L));
        addressRepository.save(address);

    }
}
