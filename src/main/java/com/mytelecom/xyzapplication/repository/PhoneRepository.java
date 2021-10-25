package com.mytelecom.xyzapplication.repository;

import com.mytelecom.xyzapplication.entity.Phone;
import com.mytelecom.xyzapplication.error.PhoneNumNotFound;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PhoneRepository {

    public List<Phone> getAllPhoneNumbers() {
        return Arrays.asList(new Phone(4123123,true,1),
                new Phone(412224,false,1),
                new Phone(412225,false,2),
                new Phone(412226,false,3));
    }

    public Phone activatePhone(long phoneNumber) throws PhoneNumNotFound {
        Phone phoneObject= getAllPhoneNumbers().stream()
                .filter(phone -> phone.getPhoneNumber()==phoneNumber)
                .findFirst()
                .orElseThrow(() -> new PhoneNumNotFound("Phone not found - " + phoneNumber));
       phoneObject.setStatus(true);
       return phoneObject;
    }

    public List<Phone> getAllPhoneNumbersByCustomerId(long customerId) {
        List<Phone> phoneListByCustId= getAllPhoneNumbers().stream()
                .filter(phone -> phone.getCustomerId()==customerId)
                .collect(Collectors.toList());
        return phoneListByCustId;
    }
}
