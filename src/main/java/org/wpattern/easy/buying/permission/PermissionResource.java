package org.wpattern.easy.buying.permission;

import org.apache.tomcat.util.descriptor.web.ResourceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.PERMISSION_PATH)
public class PermissionResource extends ResourceBase {

}
