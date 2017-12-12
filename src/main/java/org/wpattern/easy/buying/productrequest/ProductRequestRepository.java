package org.wpattern.easy.buying.productrequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.easy.buying.user.User;

public interface ProductRequestRepository extends JpaRepository<ProductRequest, Long> {

}
