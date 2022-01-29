package com.netcracker.bloodbank.repository;


import com.netcracker.bloodbank.dataAccess.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepositoryExtended {
    void updatePhoneNo(UUID customerId,String newPhoneNo);
    List<Customer> getCustomerByCity(String city);
    List<Customer> sortByName();
    List<Customer> sortByAge();
    List<Customer> getCustomerByGroup(String groupId);



}
