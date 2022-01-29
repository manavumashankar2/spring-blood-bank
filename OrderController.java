package com.netcracker.bloodbank.controller;

import com.netcracker.bloodbank.exceptions.BloodGroupNotFoundException;
import com.netcracker.bloodbank.service.OrderService;
import com.netcracker.bloodbank.dataAccess.entity.Order;
import com.netcracker.bloodbank.dataAccess.models.Type;
import com.netcracker.bloodbank.utils.ApiPathNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(ApiPathNames.ORDER_CONTROLLER)
@Api(value = "Orders",description = "Transaction Details of the Blood Bank")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation(value="Place an Order")
    @PostMapping(ApiPathNames.CREATE_ORDER)
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        HttpStatus status;
        try {
            orderService.addOrder(order);
            status = HttpStatus.OK;
        } catch (BloodGroupNotFoundException exception) {
            System.out.println(exception);
            status = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<>(status);
    }

    @ApiOperation(value="Details of all the Transactions")
    @GetMapping(ApiPathNames.READ_ORDERS)
    public ResponseEntity<List<Order>> displayOrder()
    {
        List<Order> orderList=orderService.displayOrder();
        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }

    @ApiOperation(value="Get particular Order Details")
    @GetMapping(ApiPathNames.VIEW_ORDERBYID)
    public ResponseEntity<?> readByOrderId(@RequestParam UUID orderId)
    {
        Optional<Order> orderList=orderService.readById(orderId);
        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }

    @ApiOperation(value="Delete an order")
    @DeleteMapping(ApiPathNames.DELETE_ORDER)
    public ResponseEntity<String> deleteOrder(@RequestParam UUID orderId)
    {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>("Deleted Succesfully", HttpStatus.OK);
    }

    @ApiOperation(value="View Orders of a Customer")
    @GetMapping(ApiPathNames.CUSTOMER_ORDER)
    public List getAllOrdersOfCustomer(@RequestParam UUID customerId)
    {
        return orderService.getOrdersOfCustomer(customerId);
    }

    @ApiOperation(value="Get Order details by CustomerType")
    @GetMapping(ApiPathNames.ORDER_BYTYPE)
    public List<Order> getAllByType(@RequestParam("type") Type type)
    {
        return orderService.getOrdersByType(type);
    }


}