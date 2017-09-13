package org.wpattern.test.easy.buying.permission;
import org.apache.log4j.Logger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.permission.PermissionRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;


import java.util.List;

public class PermissionRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private PermissionRepository permissionRepository;

    @Test
    public void findAll_success() {
        List<Permission> permissions = permissionRepository.findAll();

        LOGGER.debug(permissions);

        assertNotNull(permissions);
        assertTrue(permissions.size() > 0);
    }

    @Test
    public void insert() {
        Permission objPermission = new Permission();
        objPermission.setRole("ROLE_TESTE");
        permissionRepository.save(objPermission);
    }

    @Test
    public void findOne_success() {
        Permission objPermission = permissionRepository.findOne(1L);

        LOGGER.debug(objPermission);

        assertNotNull(objPermission);
        assertTrue(objPermission.getId().equals(1L));
    }

}
