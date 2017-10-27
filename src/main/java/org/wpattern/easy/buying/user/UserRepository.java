package org.wpattern.easy.buying.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public UserEntity findByEmail(String email);
	
	public List<UserEntity> findByEmailOrName(String email, String name);
}
