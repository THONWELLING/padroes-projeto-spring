package com.thonwelling.padroesspring.repositories;

import com.thonwelling.padroesspring.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
