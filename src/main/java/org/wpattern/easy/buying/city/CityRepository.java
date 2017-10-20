package org.wpattern.easy.buying.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    public City findByName (String name);

    public List<City> findByNameOr(String name, Integer state_id);
}
