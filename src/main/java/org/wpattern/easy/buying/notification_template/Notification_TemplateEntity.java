package org.wpattern.easy.buying.notification_template;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "tb_notification_templateentity")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Notification_TemplateEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @NotNull
    @Size(min = 4, max = 1024)
    @Column(name = "message", length = 1024, nullable = false)
    private String message;

    @NotNull
    @Size(min = 4, max = 12)
    @Column(name = "notification_type_id", length = 12, nullable = false)
    private Integer notification_type_id;

    @NotNull
    @Size(min = 8, max = 12)
    @Column(name = "supplier_id", length = 12, nullable = false)
    private Integer supplier_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_notification", joinColumns = @JoinColumn(name = "notification_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id") )
    private List<Permission> permissions;


    public Notification_TemplateEntity() {
    }

    public Notification_TemplateEntity(String message, Integer notification_type_id, Integer supplier_id) {
        super();
        this.message = message;
        this.notification_type_id = notification_type_id;
        this.supplier_id = supplier_id;
    }

    public Notification_TemplateEntity(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNotification_type_id() {
        return this.notification_type_id;
    }

    public void setNotification_type_id (Integer notification_type_id) { this.notification_type_id = notification_type_id; }

    public Integer getSupplier_id() {
        return this.supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }


}

