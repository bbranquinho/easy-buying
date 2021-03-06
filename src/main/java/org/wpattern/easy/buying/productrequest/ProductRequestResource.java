package org.wpattern.easy.buying.productrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.security.CurrentUser;
import org.wpattern.easy.buying.user.UserRepository;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

import java.util.Date;

@RestController
@RequestMapping(path = ResourcePaths.PRODUCT_REQUEST_PATH)
public class ProductRequestResource extends GenericService<ProductRequest, Long> {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRequestRepository productRequestRepository;

    @Override
    public ProductRequest insert(@RequestBody ProductRequest productRequest) {
        productRequest.setUser(this.userRepository.findByEmail(currentUser.getActiveUser().getEmail()));
        productRequest.setRequest(new Date());

        return super.insert(productRequest);
    }

}
