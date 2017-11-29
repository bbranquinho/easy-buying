package org.wpattern.easy.buying.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.wpattern.easy.buying.address.Address;
import org.wpattern.easy.buying.permission.Permission;

import org.wpattern.easy.buying.supplier.Supplier;
import org.wpattern.easy.buying.utils.BaseEntity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_user")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class User extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;


	@NotNull
	@Size(min = 4, max = 120)
	@Column(name = "name", length = 120, nullable = false)
	private String name;

	@NotNull
	@Size(min = 4, max = 127)
	@Column(name = "last_name", length = 127, nullable = false)
	private String sobreNome;

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

	@Lob
	@Column(name = "photo")
	private byte[] photo;

	@Column(name = "address_complement")
	private String complemento;

	@Column(name = "address_number")
	private String numero;

	@Column(name = "address_reference")
	private String referencia;

	@ManyToOne
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_permission", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "permission_id") )
	private List<Permission> permissions;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_employee", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id") )
	private List<Supplier> suppliers;


	public User() {
	}
	
    public User(String name, String email, String password, String phone,String sobreNome,List<Supplier> supplier) {
    	super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.sobreNome = sobreNome;
		this.suppliers = supplier;
    }

    public User(String name) {
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

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
}
