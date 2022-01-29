package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class InventoryRepositoryImpl implements InventoryRepositoryExtended {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public void updateQuantity(String groupId,int newQuantity)
    {
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(groupId));
        mongoTemplate.updateFirst(query, Update.update("quantity",newQuantity), Inventory.class);
    }

    @Override
    public List<Inventory> sortByQty() {
        Query query=new Query();
        query.with(new Sort(Sort.Direction.DESC,"quantity"));
        return mongoTemplate.find(query,Inventory.class);
    }

}


