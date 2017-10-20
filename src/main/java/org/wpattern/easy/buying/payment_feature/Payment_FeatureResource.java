package org.wpattern.easy.buying.payment_feature;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.easy.buying.utils.GenericService;
import org.wpattern.easy.buying.utils.ResourcePaths;

@RestController
@RequestMapping(path = ResourcePaths.PAYMENT_FEATURE_PATH)
public class Payment_FeatureResource extends GenericService<Payment_Feature, Long> {
}
