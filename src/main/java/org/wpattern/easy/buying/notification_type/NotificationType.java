package org.wpattern.easy.buying.notification_type;


import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notification_type")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class NotificationType extends BaseEntity<Long> {

    @Column(name = "type")
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
