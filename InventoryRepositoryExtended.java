package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Inventory;

import java.util.List;

public interface InventoryRepositoryExtended {
     void updateQuantity(String groupId,int newQuantity);
     List<Inventory> sortByQty();
}
