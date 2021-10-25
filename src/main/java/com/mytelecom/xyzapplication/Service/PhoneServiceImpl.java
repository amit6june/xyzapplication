package com.mytelecom.xyzapplication.Service;

import com.mytelecom.xyzapplication.entity.Phone;
import com.mytelecom.xyzapplication.error.CustomerNotFound;
import com.mytelecom.xyzapplication.error.PhoneNumNotFound;
import com.mytelecom.xyzapplication.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public List<Phone> getAllPhoneNumbers() {
        return phoneRepository.getAllPhoneNumbers();
    }

    @Override
    public List<Phone> getAllPhoneNumbersByCustomerId(long customerId) throws CustomerNotFound {
         List<Phone> phoneList =phoneRepository.getAllPhoneNumbersByCustomerId(customerId);
         if(phoneList.isEmpty()){
             throw new CustomerNotFound("Customer Not Available");
         }
         return phoneList;
    }

    @Override
    public Phone activatePhone(long phoneNumber) throws PhoneNumNotFound {
        return phoneRepository.activatePhone(phoneNumber);
    }
}
