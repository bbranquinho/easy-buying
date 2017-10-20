package org.wpattern.easy.buying.product_request;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.PRODUCT_REQUEST_PATH)
public class Product_RequestResource extends GenericService<Product_Request, Long> {
}
