package com.netcracker.bloodbank.repository;


import com.netcracker.bloodbank.dataAccess.entity.Order;
import com.netcracker.bloodbank.dataAccess.models.Type;

import java.util.List;
import java.util.UUID;

public interface OrderRepositoryExtended {
    List<Order> getAllOrdersOfCustomer(UUID customerId);
    //public Boolean findAvailability(String groupId);
    List<Order> getAllOrderByType(Type type);


}
