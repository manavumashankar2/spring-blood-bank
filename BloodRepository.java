package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Blood;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRepository extends MongoRepository<Blood,String>,BloodRepositoryExtended {
}
