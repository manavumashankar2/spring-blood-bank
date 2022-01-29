package com.netcracker.bloodbank.dataAccess.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
//@Getter
//@Setter
public class Inventory {

    @Id
    private final String groupId;
    private int quantity;

    /*public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }*/



}
