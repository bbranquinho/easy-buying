package org.wpattern.easy.buying.supplier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.SUPPLIER_PATH)
public class SupplierResource extends GenericService<Supplier, Long> {
}
