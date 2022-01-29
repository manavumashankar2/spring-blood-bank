package com.netcracker.bloodbank.service;

import com.netcracker.bloodbank.exceptions.CustomerNotFoundException;
import com.netcracker.bloodbank.repository.CustomerRepository;
import com.netcracker.bloodbank.dataAccess.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void createNewCustomer(Customer customer)
    {
        customer.setCustomerId(UUID.randomUUID());
        customerRepository.save(customer);
    }
    public void updatePhoneNo(UUID customerId,String newPhoneNo)
    {
        customerRepository.updatePhoneNo(customerId,newPhoneNo);
    }

    public void deleteCustomer(UUID customerId)
    {
        customerRepository.deleteById(customerId);
    }

    public void updateCustomer(UUID customerId,Customer customer)
    {
        customer.setCustomerId(customerId);
        customerRepository.save(customer);
    }

    public List<Customer> readAll()
    {
       // List<Customer> customer=customerRepository.findAll();
        return customerRepository.findAll();
    }

    public List<Customer> getAllCustomerByCity(String city)
    {
        List<Customer> customerList=customerRepository.getCustomerByCity(city);
        if(customerList.isEmpty())
            throw new CustomerNotFoundException();
        else
            return customerList;

    }
    public Customer search(UUID customerId)
    {
        return customerRepository.findById(customerId).get();
    }

    public List<Customer> sortByName()
    {
        return customerRepository.sortByName();
    }

    public List<Customer> sortByAge()
    {
        return customerRepository.sortByAge();
    }

    public List<Customer> getCustomerByGroup(String groupId)
    {
       List<Customer> customerList=customerRepository.getCustomerByGroup(groupId);
       return customerList;
    }


}
