package org.wpattern.easy.buying.employee;

import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_employee")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class EmployeeEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 201602010251L;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_id") )
    private List<Permission> permissions;


    public EmployeeEntity() {
    }

}
