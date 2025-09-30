package com.ramonmoncao.hexagonal.application.ports.out;

import com.ramonmoncao.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
