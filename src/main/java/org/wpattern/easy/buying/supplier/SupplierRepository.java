package org.wpattern.easy.buying.supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    public Supplier findByName (String name);

    public List<Supplier> findByNameOr(String name, String description, Date register_Date);
}
