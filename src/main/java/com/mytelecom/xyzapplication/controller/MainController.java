package com.mytelecom.xyzapplication.controller;

import com.mytelecom.xyzapplication.Service.PhoneService;
import com.mytelecom.xyzapplication.entity.Phone;
import com.mytelecom.xyzapplication.error.CustomerNotFound;
import com.mytelecom.xyzapplication.error.PhoneNumNotFound;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    Logger logger=LoggerFactory.getLogger(MainController.class);

    @Autowired
    private PhoneService phoneService;

    @GetMapping(value ="/allPhoneNumbers")
    @ApiOperation("Get all the phone numbers")
    public List<Phone> getAllPhoneNumbers(){
        logger.info("Entering getAllPhoneNumbers");
        return phoneService.getAllPhoneNumbers();
    }

    @GetMapping(value ="/allPhoneNumbersByCustId/{customerid}")
    @ApiOperation("Get all the phone numbers based on Customer Id")
    public List<Phone> getAllPhoneNumbersByCustomerId(@PathVariable("customerid") Long customerId) throws CustomerNotFound {
        logger.info("Entering getAllPhoneNumbersByCustomerId");
        return phoneService.getAllPhoneNumbersByCustomerId(customerId);
    }

    @GetMapping(value ="/activatePhoneNumber/{phoneNum}")
    public String activatePhoneNumber(@PathVariable("phoneNum")Long phoneNumber) throws PhoneNumNotFound {
        logger.info("Entering activatePhoneNumber");
        phoneService.activatePhone(phoneNumber);
         return "Phone number activated";
    }
}
