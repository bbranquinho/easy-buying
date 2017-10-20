package org.wpattern.easy.buying.notification_type;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "tb_notification_typeentity")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Notification_TypeEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 45)
    @Column(name = "type", length = 45, nullable = false)
    private String type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_notification_type", joinColumns = @JoinColumn(name = "notification_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id") )
    private List<Permission> permissions;


    public Notification_TypeEntity() {
    }

    public Notification_TypeEntity(String type) {
        super();
        this.type = type;
    }

   // public Notification_TypeEntity(String type) {
     //   this.type = type;
    //}

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

