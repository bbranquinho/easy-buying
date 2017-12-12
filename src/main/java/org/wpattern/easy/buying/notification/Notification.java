package org.wpattern.easy.buying.notification;

import org.wpattern.easy.buying.notification_template.NotificationTemplate;
import org.wpattern.easy.buying.quotation.Quotation;
import org.wpattern.easy.buying.utils.AppUtil;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "tb_notification")
public class Notification extends BaseEntity<Long> {

    @Column(name = "remetente")
    private String remetente;

    @Column(name = "destinatario")
    private String destinatario;


    @Column(name = "cc")
    private String cc;


    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;


    @ManyToOne
    @JoinColumn(name = "notification_template_id", nullable = false)
    private NotificationTemplate notification_template;

    @ManyToOne
    @JoinColumn(name = "quotation_id", nullable = false)
    private Quotation quotation_id;


    public Notification() {

    }

    public Notification(String remetente, String destinatario, String subject, String message) {
        this();
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.subject = subject;
        this.message = message;
    }


    public Notification(String remetente, String destinatario, String subject, String message, NotificationTemplate notification_template,Quotation quotation_id ) {
        this();
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.subject = subject;
        this.message = message;
        this.notification_template = notification_template;
        this.quotation_id = quotation_id;
    }


    /**
     * @return the from
     */
    public String getRemetente() {
        return remetente;
    }

    /**
     * @param remetente
     *            the from to set
     */
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject
     *            the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }


    public NotificationTemplate getNotification_template() {
        return notification_template;
    }

    public void setNotification_template(NotificationTemplate notification_template) {
        this.notification_template = notification_template;
    }

    public Quotation getQuotation_id() {
        return quotation_id;
    }

    public void setQuotation_id(Quotation quotation_id) {
        this.quotation_id = quotation_id;
    }
}
