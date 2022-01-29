package com.netcracker.bloodbank.dataAccess.entity;


import com.netcracker.bloodbank.dataAccess.models.Type;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
@Data
public class Order {
    @DBRef
    private Customer customer;
    @Id
    private UUID orderId;

   /* public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UUID getoId() {
        return oId;
    }

    public void setoId(UUID oId) {
        this.oId = oId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }*/

    //private UUID cId;
    private final int quantity;
    private Date orderDate;
    private Type type;
}
