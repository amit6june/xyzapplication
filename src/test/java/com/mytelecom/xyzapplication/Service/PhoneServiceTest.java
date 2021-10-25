package com.mytelecom.xyzapplication.Service;

import com.mytelecom.xyzapplication.entity.Phone;
import com.mytelecom.xyzapplication.repository.PhoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneServiceTest {

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private PhoneRepository phoneRepository;

    @BeforeEach
    void setUp() {
        //Phone phoneObj1=Phone.builder().phoneNumber(43211).customerId(1).status(true).build();
        //Phone phoneObj2=Phone.builder().phoneNumber(43211).customerId(2).status(true).build();
        //List<Phone> phoneDummyList=new ArrayList<>();
        //phoneDummyList.add(phoneObj1);
        //phoneDummyList.add(phoneObj2);
        //Mockito.when(phoneRepository.getAllPhoneNumbersByCustomerId(1L))
        //        .thenReturn(phoneDummyList);
    }


    @Test
    @DisplayName("Get Data based on Valid Customer Id")
    void whenValidCustomer_thenPhoneNumbersByCustomerIdShouldFound() {
        long customerId=1;

        List<Phone> phoneList =phoneRepository.getAllPhoneNumbersByCustomerId(customerId);
        assertEquals(phoneList.toArray().length, 2);
    }

    @Test
    @DisplayName("Get Data based on InValid Customer Id")
    void whenInValidCustomer_thenPhoneNumbersByCustomerIdShouldNotFound() {
        long customerId=30;

        List<Phone> phoneList =phoneRepository.getAllPhoneNumbersByCustomerId(customerId);
        assertEquals(phoneList.toArray().length, 0);
    }


}