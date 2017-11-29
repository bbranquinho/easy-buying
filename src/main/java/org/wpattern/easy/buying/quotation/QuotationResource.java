package org.wpattern.easy.buying.quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.security.CurrentUser;
import org.wpattern.easy.buying.supplier.Supplier;
import org.wpattern.easy.buying.supplier.SupplierRepository;
import org.wpattern.easy.buying.user.UserRepository;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.QUOTATION_PATH)
public class QuotationResource extends GenericService<Quotation, Long> {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuotationResource quotationResource;

    @Autowired
    private SupplierRepository supplier;


    @Override
    public Quotation insert(@RequestBody Quotation  quotation) {
        quotation.setSupplier(this.supplier.getOne(1L));

        return super.insert(quotation);

}

}
