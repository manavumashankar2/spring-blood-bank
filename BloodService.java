package com.netcracker.bloodbank.service;
import com.netcracker.bloodbank.exceptions.BloodGroupNotFoundException;
import com.netcracker.bloodbank.repository.BloodRepository;
import com.netcracker.bloodbank.dataAccess.entity.Blood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodService {
    @Autowired
    BloodRepository bloodRepository;

    public void addGroup(Blood bloodGroup)
    {
        bloodRepository.save(bloodGroup);
    }

    public void updatePrice(String groupId,int price)
    {
        bloodRepository.updatePrice(groupId,price);
    }

    public void deleteGroup(String groupId)
    {
        bloodRepository.deleteById(groupId);
    }

    public List<Blood> getAllGroups()
    {
       return bloodRepository.findAll();
    }

    public int getGroupPrice(String groupId)
    {
        Optional<Blood> bgroup=bloodRepository.findById(groupId);
        if(!bgroup.isPresent())
        {
            throw new BloodGroupNotFoundException();
        }
        Blood group=bgroup.get();
        return group.getPrice();
    }

    public Blood getBloodGroup(String groupId)
    {
        Optional<Blood> bgroup=bloodRepository.findById(groupId);
        if(!bgroup.isPresent())
            throw new BloodGroupNotFoundException(groupId);
        Blood group=bgroup.get();
        return group;

    }

    public List<Blood> getInPriceRange(int price)
    {
        List<Blood> b=bloodRepository.getInPriceRange(price);
        if(b.isEmpty())
            throw new BloodGroupNotFoundException();
        else
            return b;
    }

}
