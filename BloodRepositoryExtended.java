package com.netcracker.bloodbank.repository;

import com.netcracker.bloodbank.dataAccess.entity.Blood;


import java.util.List;


public interface BloodRepositoryExtended {
    void updatePrice(String groupId,int newPrice);
    List<Blood> getInPriceRange(int price);
}
