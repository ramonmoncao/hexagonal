package com.ramonmoncao.hexagonal.application.ports.in;

import com.ramonmoncao.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
