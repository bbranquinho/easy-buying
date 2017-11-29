package org.wpattern.easy.buying.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.easy.buying.supplier.Supplier;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	
	public List<User> findByEmailOrName(String email, String name);

	public List<Supplier> findBySuppliers(User user);
}
