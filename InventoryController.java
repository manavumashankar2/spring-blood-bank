package com.netcracker.bloodbank.controller;


import com.netcracker.bloodbank.service.InventoryService;
import com.netcracker.bloodbank.dataAccess.entity.Inventory;
import com.netcracker.bloodbank.utils.ApiPathNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPathNames.INVENTRORY_CONTROLLER)
@Api(value="Inventory",description = "Inventory maintaining the stock updates")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @PostMapping(value = "/add")
    @ApiOperation(ApiPathNames.ADD_STOCK)
    public ResponseEntity<String> addStock(@RequestBody Inventory inventory) {
        inventoryService.addStock(inventory);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @ApiOperation(value="View Stock Details")
    @GetMapping(ApiPathNames.DISPLAY_STOCK)
    public List<Inventory> displayDetailsOfStock() {
        return inventoryService.displayStock();
    }

    @ApiOperation(value="Delete group ")
    @DeleteMapping(ApiPathNames.DELETE_STOCK)
    public ResponseEntity<String> deleteGroup(@RequestParam String groupId)
    {
        inventoryService.deleteGroup(groupId);
        return new ResponseEntity<>("Deleted Succesfully", HttpStatus.OK);
    }

    @ApiOperation(value="Update Stock Quantity")
    @PutMapping(ApiPathNames.UPADTE_STOCK)
    public ResponseEntity<String> updateQuantity(@RequestParam String groupId, @RequestParam int quantity)
    {
        inventoryService.updateQuantity(groupId,quantity);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }

    @ApiOperation(value="View current quantity of Group")
    @GetMapping(ApiPathNames.GE_STOCKBY_GROUP)
    public ResponseEntity<Integer> getQuantity(@RequestParam String groupId)
    {
        Integer groupQuantity=inventoryService.getGroupQuantity(groupId);
        return new ResponseEntity<Integer>(groupQuantity,HttpStatus.OK);
    }

    @ApiOperation(value="View groups sorted by Quantity")
    @GetMapping(ApiPathNames.STOCK_BYQUANTITY)
    public List<Inventory> sortStockByQuantity()
    {
        return inventoryService.sortByQuantity();
    }
}
