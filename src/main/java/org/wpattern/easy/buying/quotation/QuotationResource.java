package org.wpattern.easy.buying.quotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.QUOTATION_PATH)
public class QuotationResource extends GenericService<Quotation, Long> {
}
