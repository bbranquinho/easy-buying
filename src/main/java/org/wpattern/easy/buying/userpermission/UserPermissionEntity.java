package org.wpattern.easy.buying.userpermission;

import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user_permission")
public class UserPermissionEntity extends BaseEntity<UserPermissionKey> {

    private static final long serialVersionUID = 201602010251L;
}
