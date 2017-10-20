package org.wpattern.easy.buying.supplier_product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.supplier_product.Supplier_Product;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;


@RestController
@RequestMapping(path = ResourcePaths.SUPPLIER_PRODUCT_PATH)
public class Supplier_ProductResource extends GenericService<Supplier_Product, Long> {
}
