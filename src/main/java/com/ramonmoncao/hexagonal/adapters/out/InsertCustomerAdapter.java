package com.ramonmoncao.hexagonal.adapters.out;

import com.ramonmoncao.hexagonal.adapters.out.repository.CustomerRepository;
import com.ramonmoncao.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.ramonmoncao.hexagonal.application.core.domain.Customer;
import com.ramonmoncao.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toEntity(customer);
        customerRepository.save(customerEntity);
    }
}
