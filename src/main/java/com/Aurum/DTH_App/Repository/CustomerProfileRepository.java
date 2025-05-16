package com.Aurum.DTH_App.Repository;

import com.Aurum.DTH_App.Entity.CustomerProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfileRepository extends MongoRepository<CustomerProfile,Integer> {
}
