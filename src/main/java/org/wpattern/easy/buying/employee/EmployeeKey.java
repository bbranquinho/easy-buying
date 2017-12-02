package org.wpattern.easy.buying.employee;

import org.wpattern.easy.buying.utils.BaseKey;

import javax.persistence.Column;
import java.io.Serializable;

public class EmployeeKey extends BaseKey {

    @Column(name = "supplier_id", length = 11, nullable = false)
    private Long permissionId;

    @Column(name = "user_id", length = 11, nullable = false)
    private Long userId;

    public EmployeeKey() {
    }

    public EmployeeKey(Long permissionId, Long userId) {
        super();
        this.permissionId = permissionId;
        this.userId = userId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EmployeeKey that = (EmployeeKey) o;

        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        int result = permissionId != null ? permissionId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
