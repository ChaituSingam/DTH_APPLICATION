package com.Aurum.DTH_App.Repository;

import com.Aurum.DTH_App.Entity.Registration;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration, Integer> {
}
