package org.wpattern.test.easy.buying.state;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.state.State;
import org.wpattern.easy.buying.state.StateRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class StateRepositoryTest extends BaseEntityTest {


    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private StateRepository stateRepository;

    @Test
    public void findAll_success() {
     List<State> states = stateRepository.findAll();

     LOGGER.debug(states);

     assertNotNull(states);
     assertTrue(states.size() > 0);

    }

    @Test
    public void insert() {
        State state = new State();
        state.setName("MINAS GERAIS");
        state.setSymbol("MG");
        stateRepository.save(state);
    }
}
