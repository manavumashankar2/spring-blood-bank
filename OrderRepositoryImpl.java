package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Order;
import com.netcracker.bloodbank.dataAccess.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepositoryExtended{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<Order> getAllOrdersOfCustomer(UUID customerId) {
        return mongoTemplate.find(Query.query(Criteria.where("Customer.customerId").is(customerId)),Order.class);

    }


    public List<Order> getAllOrderByType(Type type)
    {
        Query query=new Query();
        query.addCriteria(Criteria.where("type").is(type));
        return mongoTemplate.find(query,Order.class);
    }
}
