package org.wpattern.easy.buying.client;

import org.wpattern.easy.buying.person.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
@DiscriminatorValue("1")
public class Client extends Person {


}
