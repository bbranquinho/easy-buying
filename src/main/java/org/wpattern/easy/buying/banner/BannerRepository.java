package org.wpattern.easy.buying.banner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    public Banner findByMessage (String message);

    public List<Banner> findByMessageOrExpiration(String message, Date expiration);
}