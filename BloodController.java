package com.netcracker.bloodbank.controller;

import com.netcracker.bloodbank.service.BloodService;
import com.netcracker.bloodbank.dataAccess.entity.Blood;
import com.netcracker.bloodbank.utils.ApiPathNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="Blood", description="Operations pertaining to Blood Entity")
@RequestMapping(ApiPathNames.BLOOD_CONTROLLER)
public class BloodController {

    @Autowired
    BloodService bloodService;

    @ApiOperation(value="Create New Blood Group")
    @PostMapping(ApiPathNames.CREATE_BGROUP)
    public ResponseEntity<String> createNewBloodGroup(@RequestBody Blood bloodGroup)
    {
        bloodService.addGroup(bloodGroup);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @ApiOperation(value="Update the Price of Group")
    @PutMapping(ApiPathNames.UPDATE_BGROUP)
    public ResponseEntity<String> updatePrice(@RequestParam String groupId, @RequestParam int price)
    {
        bloodService.updatePrice(groupId,price);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }

    @ApiOperation(value="Delete Group")
    @DeleteMapping(ApiPathNames.DELETE_GROUP)
    public ResponseEntity<String> deleteGroup(@RequestParam String groupId)
    {
        bloodService.deleteGroup(groupId);
        return new ResponseEntity<>("Deleted Succesfully",HttpStatus.OK);
    }

    @ApiOperation(value="View List of all the Blood Groups")
    @GetMapping(ApiPathNames.GET_ALL_GROUPS)
    public ResponseEntity<List> getGroups()
    {
        List<Blood> bgroup=bloodService.getAllGroups();
        return new ResponseEntity<List>(bgroup,HttpStatus.OK);
    }

    @ApiOperation(value="View groups within a given price")
    @GetMapping(ApiPathNames.GET_IN_RANGE)
    public ResponseEntity<?> getInRange(@RequestParam int range)
    {
        List<Blood> rangeList=bloodService.getInPriceRange(range);
        return new ResponseEntity<List>(rangeList,HttpStatus.OK);
    }

    @ApiOperation(value="View price of a group")
    @GetMapping(ApiPathNames.GET_GROUP_PRICE)
    public ResponseEntity<Integer> getCost(@RequestParam String groupId)
    {
        Integer groupCost=bloodService.getGroupPrice(groupId);
        return new ResponseEntity<Integer>(groupCost,HttpStatus.OK);
    }

    @ApiOperation(value="Details of a particular group")
    @GetMapping(ApiPathNames.GET_GROUP)
    public ResponseEntity<Blood> getGroup(@RequestParam String groupId)
    {
        return new ResponseEntity<Blood>(bloodService.getBloodGroup(groupId),HttpStatus.OK);
    }


}
