package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryExtended {
    @Autowired
    MongoTemplate mongoTemplate;
    public void updatePhoneNo(UUID customerId, String newPhoneNo)
    {
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(customerId));
        mongoTemplate.updateFirst(query, Update.update("phoneNumber",newPhoneNo), Customer.class);
    }

    @Override
    public List<Customer> getCustomerByCity(String city) {
        Query query=new Query();
        query.addCriteria(Criteria.where("address.city").is(city));
        return mongoTemplate.find(query,Customer.class);
    }

    public List<Customer> getCustomerByGroup(String groupId)
    {
        Query query=new Query();
        query.addCriteria(Criteria.where("blood.groupId").is(groupId));
        return mongoTemplate.find(query,Customer.class);
    }

    public List<Customer> sortByName()
    {
        Query query=new Query();
        query.with(new Sort(Sort.Direction.ASC,"name"));
        return mongoTemplate.find(query,Customer.class);
    }

    public List<Customer> sortByAge()
    {
        Query query=new Query();
        query.with(new Sort(Sort.Direction.DESC,"age"));
        return mongoTemplate.find(query,Customer.class);
    }


}
