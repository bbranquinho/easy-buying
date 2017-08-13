package org.wpattern.easy.buying.domain.user;

import org.apache.tomcat.util.descriptor.web.ResourceBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.ResourcePaths;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = ResourcePaths.USER_PATH)
public class UserResource extends ResourceBase {

    @GetMapping
    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<UserEntity>();

        users.add(new UserEntity("User 1"));

        return users;
    }

}
