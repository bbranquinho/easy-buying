package org.wpattern.easy.buying.employee;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_employee")
@AttributeOverride(name = "id" , column = @Column(name = "pk_id"))
public class Employee extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    public Employee() {
    }
}
