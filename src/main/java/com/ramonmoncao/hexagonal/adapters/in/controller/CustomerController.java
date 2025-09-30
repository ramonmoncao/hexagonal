package com.ramonmoncao.hexagonal.adapters.in.controller;

import com.ramonmoncao.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.ramonmoncao.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.ramonmoncao.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.ramonmoncao.hexagonal.application.core.domain.Customer;
import com.ramonmoncao.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.ramonmoncao.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.ramonmoncao.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var response = customerMapper.toResponse(customer);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

}
