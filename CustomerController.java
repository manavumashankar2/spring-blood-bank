package com.netcracker.bloodbank.controller;
import com.netcracker.bloodbank.service.CustomerService;
import com.netcracker.bloodbank.dataAccess.entity.Customer;
import com.netcracker.bloodbank.utils.ApiPathNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ApiPathNames.CUSTOMER_CONTROLLER)
@Api(value="Customer",description = "Operations peratining to Customer Entity")

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping (ApiPathNames.CREATE_CUSTOMER)
    @ApiOperation(value="Create a new Customer Entry")
   public ResponseEntity<String> createNewCustomer(@RequestBody Customer customer)
    {
        customerService.createNewCustomer(customer);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @ApiOperation(value="Update the contact details")
    @GetMapping(ApiPathNames.UPDATE_CUSTOMER_PHONENUMBER)
    public ResponseEntity<String> updatePhoneNo(@RequestParam UUID customerId, @RequestParam String newPhoneNo)
    {
        customerService.updatePhoneNo(customerId,newPhoneNo);
        return new ResponseEntity<>("Upadted",HttpStatus.OK);
    }

    @ApiOperation(value="Delete a customer entry")
    @DeleteMapping(ApiPathNames.DELETE_CUSTOMER)
    public void deleteCustomer(@RequestParam UUID customerId)
    {
        customerService.deleteCustomer(customerId);
    }

    @ApiOperation(value="View details fo all the customer")
    @GetMapping(ApiPathNames.READ_CUSTOMERS)
    public ResponseEntity<List<Customer>> readAll()
    {
        return new ResponseEntity<>(customerService.readAll(),HttpStatus.OK);
    }

    @ApiOperation(value="Details of customer by City ")
    @GetMapping(ApiPathNames.CUSTOMER_BY_CITY)
    public ResponseEntity<List<Customer>> getCustomerByCity(@RequestParam String city)
    {
        return new ResponseEntity<>(customerService.getAllCustomerByCity(city), HttpStatus.OK);
    }

    @ApiOperation(value = "Customer details sorted by name")
    @GetMapping(ApiPathNames.CUSTOMER_SORTED_BY_NAME)
    public List<Customer> sortCustomerByName()
    {
        return customerService.sortByName();
    }

    @ApiOperation(value="Customer details according to age")
    @GetMapping(ApiPathNames.CUSTOMER_SORTED_BY_AGE)
    public List<Customer> sortCustomerByAge()
    {
        return customerService.sortByAge();
    }

    @ApiOperation(value="Update customer details")
    @PutMapping(ApiPathNames.UPDATE_CUSTOMER)
    public ResponseEntity<?> updateCustomer(@RequestParam UUID customerId,@RequestBody Customer customer)
    {
        customerService.updateCustomer(customerId,customer);
        return new ResponseEntity<>("updated",HttpStatus.OK);
    }

    @ApiOperation(value ="View Customers with similar blood group" )
    @GetMapping(ApiPathNames.CUSTOMER_BY_GROUP)
    public ResponseEntity<List<Customer>> getCustomerByBloodGroup(@RequestParam String groupId)
    {
        return new ResponseEntity<>(customerService.getCustomerByGroup(groupId),HttpStatus.OK);

    }

}
