package com.mytelecom.xyzapplication.Service;

import com.mytelecom.xyzapplication.entity.Phone;
import com.mytelecom.xyzapplication.error.CustomerNotFound;
import com.mytelecom.xyzapplication.error.PhoneNumNotFound;

import java.util.List;

public interface PhoneService {
    List<Phone> getAllPhoneNumbers();

    List<Phone> getAllPhoneNumbersByCustomerId(long customerId) throws CustomerNotFound;

    Phone activatePhone(long phoneNumber) throws PhoneNumNotFound;
}
