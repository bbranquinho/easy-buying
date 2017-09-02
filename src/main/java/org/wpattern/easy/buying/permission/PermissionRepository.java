package org.wpattern.easy.buying.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.easy.buying.domain.user.UserEntity;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {


}
