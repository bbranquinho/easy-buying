package org.wpattern.easy.buying.notification_type;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_notification_type")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Notification_Type extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 45)
    @Column(name = "type", length = 45, nullable = false)
    private String type;

    public Notification_Type() {
    }

    public Notification_Type(String type) {
        super();
        this.type = type;
    }

   // public Notification_Type(String type) {
     //   this.type = type;
    //}

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

