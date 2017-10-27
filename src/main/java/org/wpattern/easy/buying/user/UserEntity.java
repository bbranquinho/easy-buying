package org.wpattern.easy.buying.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_user")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class UserEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;
	
	@NotNull
	@Size(min = 4, max = 120)
	@Column(name = "name", length = 120, nullable = false)
    private String name;
	
	@Email
	@NotNull
	@NotEmpty
	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;

	
	@NotNull
	@Size(min = 3, max = 80)
	@Column(name = "password", length = 80, nullable = false)
	private String password;

	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "phone", length = 11, nullable = false)
	private String phone;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_permission", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "permission_id") )
	private List<Permission> permissions;


	public UserEntity() {
	}
	
    public UserEntity(String name, String email, String password, String phone) {
    	super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
    }

    public UserEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
