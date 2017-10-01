package org.wpattern.test.easy.buying.city;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.city.City;
import org.wpattern.easy.buying.city.CityRepository;
import org.wpattern.easy.buying.state.StateRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class CityRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Test
    public void findAll_success() {
        List<City> citys = cityRepository.findAll();

        LOGGER.debug(citys);

        assertNotNull(citys);
        assertTrue(citys.size() > 0);
    }

    @Test
    public void insert() {
        City city = new City();
        city.setName("Uberlândia");
        city.setState(stateRepository.findOne(1L));
        cityRepository.save(city);
    }
}
