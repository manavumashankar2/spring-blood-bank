package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, UUID>,CustomerRepositoryExtended {
}
