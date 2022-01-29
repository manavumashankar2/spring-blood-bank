package com.netcracker.bloodbank.service;

import com.netcracker.bloodbank.exceptions.OutOfStockException;
import com.netcracker.bloodbank.repository.InventoryRepository;
import com.netcracker.bloodbank.dataAccess.entity.Inventory;
import com.netcracker.bloodbank.dataAccess.models.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
   OrderService orderService;

    public void decrementStock(String groupId, Type type, int qty) {
       // log.info("gid" + groupId);
        Inventory inventory = inventoryRepository.findById(groupId).get();
        System.out.println(inventory);
        inventory.setQuantity(inventory.getQuantity()-qty);
        inventoryRepository.save(inventory);
    }
    public void incrementStock(String groupId,Type type,int qty)
    {
        Inventory inventory=inventoryRepository.findById(groupId).get();
        inventory.setQuantity(inventory.getQuantity()+qty);
        inventoryRepository.save(inventory);
    }
    public void addStock(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    public List<Inventory> displayStock() {
        return inventoryRepository.findAll();
    }

    public void deleteGroup(String groupId)
    {
        inventoryRepository.deleteById(groupId);
    }

    public void updateQuantity(String groupId,int quantity)
    {
        inventoryRepository.updateQuantity(groupId,quantity);
    }

    public int getGroupQuantity(String groupId)
    {
        Optional<Inventory> inventoryOptional=inventoryRepository.findById(groupId);
        if(inventoryOptional.get().getQuantity()==0)
        {
                throw new OutOfStockException();
        }
        Inventory inventory=inventoryOptional.get();
        return inventory.getQuantity();
    }

    public List<Inventory> sortByQuantity()
    {
        return inventoryRepository.sortByQty();
    }


}


