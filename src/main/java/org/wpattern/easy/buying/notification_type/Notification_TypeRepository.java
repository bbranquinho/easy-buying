package org.wpattern.easy.buying.notification_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.easy.buying.notification_type.Notification_Type;

import java.util.List;

public interface Notification_TypeRepository extends JpaRepository<org.wpattern.easy.buying.notification_type.Notification_TypeRepository, Long> {

    public Notification_Type findByType (String type);

    public List<Notification_Type> findByTypeOr(String type);
}
