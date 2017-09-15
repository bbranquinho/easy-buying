package org.wpattern.test.easy.buying.domain.user;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.permission.PermissionRepository;
import org.wpattern.easy.buying.user.User;
import org.wpattern.easy.buying.user.UserRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Test
    public void findAll_success() {
        List<User> users = userRepository.findAll();

        LOGGER.debug(users);

        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    public void insert() {
        //Usuario
        User objUser = new User();

        objUser.setName("Eina");
        objUser.setEmail("eina@gmail.com");
        objUser.setPassword("admin");
        objUser.setPhone("34992048276");

        userRepository.save(objUser);
    }


    @Test
    public void insert_construct() {
        //Usuario
        User objUser = new User("Wannisson", "wannisson@test.com", "123", "34991393623");

        List<Permission> lstPermission = new ArrayList<Permission>();
        lstPermission.add(permissionRepository.findByRole("ROLE_ADMIN"));
        objUser.setPermissions(lstPermission);

        userRepository.save(objUser);
    }



}
