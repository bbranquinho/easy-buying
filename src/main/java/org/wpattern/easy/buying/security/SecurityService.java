package org.wpattern.easy.buying.security;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.ResourceBase;
import org.wpattern.easy.buying.utils.ResourcePaths;


@RestController
@RequestMapping(ResourcePaths.LOGIN_PATH)
public class SecurityService implements ResourceBase {

	@RequestMapping(method = { RequestMethod.GET })
	public Principal user(Principal user) {
		return user;
	}

}
