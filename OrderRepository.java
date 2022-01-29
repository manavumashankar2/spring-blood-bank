package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order,UUID>, OrderRepositoryExtended {

}
