package org.wpattern.easy.buying.neighborhood;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long>{

    public Neighborhood findByName (String name);

    public List<Neighborhood> findByNameOr(String name, Integer city_id);
}
