package com.ramonmoncao.hexagonal.adapters.out;

import com.ramonmoncao.hexagonal.adapters.out.repository.CustomerRepository;
import com.ramonmoncao.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
