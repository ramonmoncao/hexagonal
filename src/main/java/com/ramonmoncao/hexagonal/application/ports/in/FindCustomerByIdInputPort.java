package com.ramonmoncao.hexagonal.application.ports.in;

import com.ramonmoncao.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
