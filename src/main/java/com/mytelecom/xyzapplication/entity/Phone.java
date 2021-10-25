package com.mytelecom.xyzapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone {

    public long phoneNumber;
    public boolean status;
    public long customerId;
}
