package org.wpattern.easy.buying.state;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    public State findByName(String name);

    public List<State> findByNameOr(String name, String symbol);
}
