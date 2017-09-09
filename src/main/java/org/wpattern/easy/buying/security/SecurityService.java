package org.wpattern.easy.buying.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.ResourcePaths;
import org.wpattern.easy.buying.utils.ServiceMap;

import java.security.Principal;


@RestController
@RequestMapping(ResourcePaths.LOGIN_PATH)
public class SecurityService implements ServiceMap {

	@RequestMapping(method = { RequestMethod.GET })
	public Principal user(Principal user) {
		return user;
	}

}
