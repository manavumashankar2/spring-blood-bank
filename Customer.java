package com.netcracker.bloodbank.dataAccess.entity;


import com.netcracker.bloodbank.dataAccess.models.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class Customer {
    @DBRef
    private Blood blood;

    /*public void setcId(UUID cId) {
        this.cId = cId;
    }

    public UUID getcId() {
        return cId;
    }

    public Blood getBlood() {
        return blood;
    }*/

    @Id
    private UUID customerId;
    private final String name;
    private final int age;
    private Address address;
    private final String phoneNumber;
   // private int groupId;

}
