package org.wpattern.easy.buying.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    public List<Client> findByUser(Client client);

    public List<Client> findByStatus(String status);
}
