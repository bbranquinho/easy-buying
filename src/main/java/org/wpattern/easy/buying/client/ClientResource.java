package org.wpattern.easy.buying.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.permission.PermissionRepository;
import org.wpattern.easy.buying.user.User;
import org.wpattern.easy.buying.user.UserRepository;
import org.wpattern.easy.buying.userpermission.UserPermission;
import org.wpattern.easy.buying.userpermission.UserPermissionKey;
import org.wpattern.easy.buying.userpermission.UserPermissionRepository;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.security.CurrentUser;


@RestController
@RequestMapping(path = ResourcePaths.CLIENT_PATH)
public class ClientResource extends GenericService<Client, Long> {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Client insert(@RequestBody Client client) {
        client.getUser().setPassword(this.passwordEncoder.encode(client.getUser().getPassword()));

        User user = new User();
        user.setEmail(client.getUser().getEmail());
        user.setName(client.getUser().getName());
        user.setPhone(client.getUser().getPhone());
        user.setPassword(client.getUser().getPassword());

        user = this.userRepository.saveAndFlush(user);

        Permission permission = this.permissionRepository.findByRole("ROLE_USER");

        if (permission == null) {
            Permission permissionAux = new Permission();
            permissionAux.setRole("ROLE_USER");

            permission = this.permissionRepository.save(permissionAux);
        }

        UserPermissionKey userPermissionKey = new UserPermissionKey();
        userPermissionKey.setPermissionId(permission.getId());
        userPermissionKey.setUserId(user.getId());

        UserPermission userPermission = new UserPermission();
        userPermission.setId(userPermissionKey);

        this.userPermissionRepository.save(userPermission);


        client.setUser(user);


        return super.insert(client);
    }

}