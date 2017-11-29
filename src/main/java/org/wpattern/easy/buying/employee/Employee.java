package org.wpattern.easy.buying.employee;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_employee")
public class Employee extends BaseEntity<EmployeeKey> {


}
