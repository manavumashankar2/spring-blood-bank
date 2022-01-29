package com.netcracker.bloodbank.service;

import com.netcracker.bloodbank.exceptions.OutOfStockException;
import com.netcracker.bloodbank.repository.InventoryRepository;
import com.netcracker.bloodbank.repository.OrderRepository;
import com.netcracker.bloodbank.dataAccess.entity.Customer;
import com.netcracker.bloodbank.dataAccess.entity.Inventory;
import com.netcracker.bloodbank.dataAccess.entity.Order;
import com.netcracker.bloodbank.dataAccess.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    InventoryService inventoryService;
    @Autowired
    InventoryRepository inventoryRepository;

    public void addOrder(Order order) {
        Inventory inventory=inventoryRepository.findById(order.getCustomer().getBlood().getGroupId()).get();
        order.setOrderId(UUID.randomUUID());
        order.setOrderDate(new Date());
        UUID cid = order.getCustomer().getCustomerId();
        System.out.println(cid);
        Customer customer = customerService.search(cid);
        String groupId = customer.getBlood().getGroupId();
        System.out.println(groupId);
        int qty = order.getQuantity();
        System.out.println(qty);
        Type type = order.getType();
        if (inventory.getQuantity() > order.getQuantity() && order.getType().equals(Type.Receiver)) {
            inventoryService.decrementStock(groupId, type, qty);
            orderRepository.save(order);
            }
        else if(order.getType().equals(Type.Donor))
        {
            inventoryService.incrementStock(groupId,type,qty);
            orderRepository.save(order);
        }
        else
            throw new OutOfStockException();
    }

    public List<Order> displayOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> readById(UUID orderId)
    {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersOfCustomer(UUID customerId) {
        return orderRepository.getAllOrdersOfCustomer(customerId);
    }

    public List<Order> getOrdersByType(Type type)
    {
        return orderRepository.getAllOrderByType(type);
    }

    public void deleteOrder(UUID orderId)
    {
        orderRepository.deleteById(orderId);
    }
}
