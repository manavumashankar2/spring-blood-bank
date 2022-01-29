package com.netcracker.bloodbank.exceptions;

public class BloodGroupNotFoundException extends RuntimeException{
    public BloodGroupNotFoundException()
    {
        super("Blood Group Not Found");
    }
    public BloodGroupNotFoundException(String id)

    {
        super("Blood Group Not Found"+id);
    }
}
