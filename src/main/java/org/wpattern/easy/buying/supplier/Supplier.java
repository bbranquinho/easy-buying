package org.wpattern.easy.buying.supplier;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.wpattern.easy.buying.utils.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_supplier")
@AttributeOverride(name ="id", column = @Column(name = "id"))
public class Supplier extends BaseEntity<Long> {

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",locale = "pt-BR", timezone = "Brazil/East")
    @Temporal(TemporalType.DATE)
    @Column(name="register_date")
    private Date registerDate;

    @Lob
    @Column(name="logo")
    private byte[] logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
