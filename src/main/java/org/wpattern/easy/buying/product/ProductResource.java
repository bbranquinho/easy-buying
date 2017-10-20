package org.wpattern.easy.buying.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.PRODUCT_PATH)
public class ProductResource extends GenericService<Product, Long> {
}
