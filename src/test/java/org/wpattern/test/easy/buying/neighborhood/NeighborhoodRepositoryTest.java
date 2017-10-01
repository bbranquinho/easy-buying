package org.wpattern.test.easy.buying.neighborhood;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.city.CityRepository;
import org.wpattern.easy.buying.neighborhood.Neighborhood;
import org.wpattern.easy.buying.neighborhood.NeighborhoodRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class NeighborhoodRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void findAll_success() {
        List<Neighborhood> neighborhoodList = neighborhoodRepository.findAll();

        LOGGER.debug(neighborhoodList);

        assertNotNull(neighborhoodList);
        assertTrue(neighborhoodList.size() > 0);

    }

    @Test
    public void insert() {
        Neighborhood neighborhood = new Neighborhood();
        neighborhood.setName("Jardim Europa");
        neighborhood.setCity(cityRepository.findOne(1L));
        neighborhoodRepository.save(neighborhood);
    }
}
