package org.wpattern.easy.buying.payment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.PAYMENT_PATH)
public class PaymentResource extends GenericService<Payment, Long> {
}

