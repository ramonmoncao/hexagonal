package com.ramonmoncao.hexagonal.config;

import com.ramonmoncao.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.ramonmoncao.hexagonal.adapters.out.InsertCustomerAdapter;
import com.ramonmoncao.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.ramonmoncao.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }
}
