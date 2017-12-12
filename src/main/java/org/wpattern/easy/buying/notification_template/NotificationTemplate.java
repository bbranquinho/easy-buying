package org.wpattern.easy.buying.notification_template;


import org.wpattern.easy.buying.notification_type.NotificationType;
import org.wpattern.easy.buying.supplier.Supplier;
import org.wpattern.easy.buying.utils.AppUtil;
import org.wpattern.easy.buying.utils.BaseEntity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Table(name = "tb_notification_template")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class NotificationTemplate extends BaseEntity<Long> {


    @NotNull
    @Column(name = "default_message")
    private String default_message;

    @ManyToOne
    @JoinColumn(name = "notification_type_id", nullable = false)
    private NotificationType notification_type;


    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Transient
    private Map<String, String> replacementParams;


    public String getDefault_message(Map<String, String> replacements) {
        String cTemplate = this.getDefault_message();

        if(!AppUtil.isObjectEmpty(cTemplate)){
            for (Map.Entry<String, String> entry : replacements.entrySet()) {
                cTemplate = cTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
            }
        }

        return cTemplate;
    }

    public String getDefault_message() { return default_message; }

    public void setDefault_message(String default_message) {
        this.default_message = default_message;
    }

    public NotificationType getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(NotificationType notification_type) {
        this.notification_type = notification_type;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Map<String, String> getReplacementParams() {
        return replacementParams;
    }

    public void setReplacementParams(Map<String, String> replacementParams) {
        this.replacementParams = replacementParams;
    }


}
