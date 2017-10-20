package org.wpattern.easy.buying.payment_feature;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface Payment_FeatureRepository extends JpaRepository<Payment_Feature, Long> {

    public Payment_Feature findByValue (Float value);

    public List<Payment_Feature> findByValueOr(Float value, Integer month_number, Integer banner_numbe);
}
