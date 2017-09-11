package org.wpattern.easy.buying.person;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.wpattern.easy.buying.user.User;
import org.wpattern.easy.buying.utils.BaseEntity;


@Entity
@Table(name = "tb_person")
@AttributeOverride(name = "id", column = @Column(name = "id_person"))
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Person extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Column(nullable = false, length = 70)
    private String bairro;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String cep;


    @NotBlank
    @Column(nullable = false, length = 70)
    private String cidade;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String estado;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String rua;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String numero;


    @NotBlank
    @Column(nullable = false, length = 20)
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
