package com.ramonmoncao.hexagonal.application.ports.out;

import com.ramonmoncao.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
