package com.thonwelling.padroesspring.repositories;

import com.thonwelling.padroesspring.controller.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String>{
}
