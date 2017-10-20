package org.wpattern.easy.buying.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long>{

    public Address findByDistrict_id (Integer district_id);

    public List<Address> findByDistrict_idOr(Integer district_id, String name, String cep);
}
