package com.Aurum.DTH_App.Repository;

import com.Aurum.DTH_App.Entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address,Integer> {
}
