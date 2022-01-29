package com.netcracker.bloodbank.dataAccess.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Blood {
    @Id
    private final String groupId;
    private final int price;

   /* public void setGroupId(String groupId) {
        this.groupId = groupId;
    }*/



   /* public String getGroupId() {
        return groupId;
    }

    public int getPrice() {
        return price;
    }*/
}
