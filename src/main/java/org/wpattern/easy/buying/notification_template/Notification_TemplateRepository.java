package org.wpattern.easy.buying.notification_template;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Notification_TemplateRepository extends JpaRepository<Notification_TemplateRepository, Long> {

    public Notification_Template findByMessage (String message);

    public List<Notification_Template> findByMessageOr(String mesage, Integer notification_type_id, Integer supplier_id);
}
