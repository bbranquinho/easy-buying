package org.wpattern.easy.buying.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.permission.PermissionRepository;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = ResourcePaths.USER_PATH)
public class UserResource extends GenericService<User, Long> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public User insert(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if(user.getPermissions().get(0).getRole().equals("ROLE_USER")){
            List<Permission> permissionList = new ArrayList<Permission>();
            permissionList.add(permissionRepository.findByRole("ROLE_CLIENTE"));

            user.setPermissions(permissionList);
        }
        return super.insert(user);
    }

}
