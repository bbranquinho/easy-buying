package org.wpattern.easy.buying.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    public Payment findByDate (Date date);

    public List<Payment> findByDateOr(Date date, Date expiration, Float value);
}
