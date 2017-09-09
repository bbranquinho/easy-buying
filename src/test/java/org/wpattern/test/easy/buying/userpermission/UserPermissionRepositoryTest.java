package org.wpattern.test.easy.buying.userpermission;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.user.UserRepository;
import org.wpattern.easy.buying.permission.PermissionRepository;
import org.wpattern.easy.buying.userpermission.UserPermissionEntity;
import org.wpattern.easy.buying.userpermission.UserPermissionKey;
import org.wpattern.easy.buying.userpermission.UserPermissionRepository;
import org.wpattern.test.easy.buying.utils.BaseTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserPermissionRepositoryTest extends BaseTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRepository userRepository;


    @Ignore
    @Test
    public void findAll_success() {
        List<UserPermissionEntity> userPermissions = userPermissionRepository.findAll();

        LOGGER.debug(userPermissions);

        assertNotNull(userPermissions);
        assertTrue(userPermissions.size() > 0);
    }

    @Ignore
    @Test
    public void insert() {
        UserPermissionKey objUserPermissionKey = new UserPermissionKey();
        UserPermissionEntity objUserPermission = new UserPermissionEntity();

        objUserPermissionKey.setUserId(userRepository.getOne(1L).getId());
        objUserPermissionKey.setPermissionId(permissionRepository.getOne(1L).getId());

        objUserPermission.setId(objUserPermissionKey);

        userPermissionRepository.save(objUserPermission);
    }

}
