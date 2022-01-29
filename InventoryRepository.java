package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String>,InventoryRepositoryExtended {
}
