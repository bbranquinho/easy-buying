package org.wpattern.test.easy.buying.domain.user;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.domain.user.UserEntity;
import org.wpattern.easy.buying.domain.user.UserRepository;
import org.wpattern.test.easy.buying.utils.BaseTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserRepositoryTest extends BaseTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll_success() {
        List<UserEntity> users = userRepository.findAll();

        LOGGER.debug(users);

        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    public void insert() {
        //Usuario
        UserEntity objUser = new UserEntity();

        objUser.setName("Wannisson");
        objUser.setEmail("wannisson@gmail.com");
        objUser.setPassword("123");
        objUser.setPhone("34991393623");

        userRepository.save(objUser);
    }

}
