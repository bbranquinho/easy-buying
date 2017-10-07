package org.wpattern.easy.buying.productrequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.PRODUCT_REQUEST_PATH)
public class ProductRequestResource extends GenericService<ProductRequest, Long> {
}
