package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Blood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class BloodRepositoryImpl implements BloodRepositoryExtended {

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public void updatePrice(String groupId,int newPrice)
    {
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(groupId));
        mongoTemplate.updateFirst(query, Update.update("price",newPrice), Blood.class);
    }
    public List<Blood> getInPriceRange(int price)
    {
        Query query=new Query();
        query.addCriteria(Criteria.where("price").lt(price));
        return mongoTemplate.find(query,Blood.class);
    }

}

