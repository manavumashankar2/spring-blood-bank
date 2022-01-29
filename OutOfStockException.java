package com.netcracker.bloodbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OutOfStockException extends RuntimeException {
    public OutOfStockException()
    {
        super("Requested Quantity currently not available");
    }
}
