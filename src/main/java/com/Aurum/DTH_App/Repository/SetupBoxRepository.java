package com.Aurum.DTH_App.Repository;

import com.Aurum.DTH_App.Entity.SetupBox;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetupBoxRepository extends MongoRepository<SetupBox,Integer> {

}
