package org.wpattern.easy.buying.payment;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


    @Entity
    @Table(name = "tb_payment")
    @AttributeOverride(name = "id", column = @Column(name = "pk_id"))
    public class Payment extends BaseEntity<Long> {

        private static final long serialVersionUID = 201602010251L;

        @NotNull
        @Size(min = 4, max = 10)
        @Column(name = "Date", length = 10, nullable = false)
        private Date date;

        @NotNull
        @Size(min = 4, max = 10)
        @Column(name = "expiration", length = 10, nullable = false)
        private Date expiration;

        @NotNull
        @Size(min = 8, max = 12)
        @Column(name = "value", length = 12, nullable = false)
        private Float value;


        public Payment() {
        }

        public Payment(Date date, Date expiration, Float value) {
            super();
            this.date = date;
            this.expiration = expiration;
            this.value = value;
        }

        public Payment(Date date) {
            this.date = date;
        }

        public Date getDate() {
            return this.date;
        }

        public void setdate(Date date) {
            this.date = date;
        }

        public Date getExpiration() {
            return this.expiration;
        }

        public void setExpiration (Date expiration) { this.expiration = expiration; }

        public Float getValue() { return this.value; }

        public void setValue(Float value) { this.value = value; }


    }

