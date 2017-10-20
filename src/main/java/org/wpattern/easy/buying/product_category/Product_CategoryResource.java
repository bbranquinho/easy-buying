package org.wpattern.easy.buying.product_category;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.PRODUCT_CATEGORY_PATH)
public class Product_CategoryResource extends GenericService<Product_Category, Long>{
}
