package org.wpattern.test.easy.buying.domain.user;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.address.Address;
import org.wpattern.easy.buying.address.AddressRepository;
import org.wpattern.easy.buying.city.City;
import org.wpattern.easy.buying.neighborhood.Neighborhood;
import org.wpattern.easy.buying.permission.Permission;
import org.wpattern.easy.buying.permission.PermissionRepository;
import org.wpattern.easy.buying.state.State;
import org.wpattern.easy.buying.user.User;
import org.wpattern.easy.buying.user.UserRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserRepositoryTest extends BaseEntityTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void findAll_success() {
        List<User> users = userRepository.findAll();

        LOGGER.debug(users);

        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    public void insert() {

        //Usuario
        User objUser = new User();
        objUser.setName("Eina");
        objUser.setEmail("eina@gmail.com");
        objUser.setPassword("admin");
        objUser.setPhone("34994546776");
        objUser.setComplemeto("casa");
        objUser.setNumero("68");
        objUser.setReferencia("Perto do Sesc senat");
        objUser.setSobreNome("Santos");
        objUser.setAddress(addressRepository.findOne(1L));

        userRepository.save(objUser);
    }


    @Test
    public void insert_construct() {
        //Usuario
        User objUser = new User("Wannisson", "wannisson@test.com", "123", "34991393623");

        List<Permission> lstPermission = new ArrayList<Permission>();
        lstPermission.add(permissionRepository.findByRole("ROLE_ADMIN"));
        objUser.setPermissions(lstPermission);
        objUser.setAddress(addressRepository.findOne(1L));
        objUser.setSobreNome("Freitas");
        objUser.setReferencia("Perto do sesc senat");
        objUser.setNumero("68");
        objUser.setComplemeto("casa");
        objUser.setPassword("123");
        userRepository.save(objUser);
    }

    private Address getEndereco() {

        //Estado
        State state = new State();
        state.setName("MINAS GERAIS");
        state.setSymbol("MG");

        //Cidade
        City city = new City();
        city.setName("UBERLÂNDIA");
        city.setState(state);

        //Bairro
        Neighborhood neighborhood = new Neighborhood();
        neighborhood.setName("JARDIM EUROPA");
        neighborhood.setCity(city);

        //Endereço
        Address address = new Address();
        address.setName("Rua Iolanda Alves Figueira");
        address.setCep("38414650");
        address.setNeighborhood(neighborhood);

        return address;
    }



}
