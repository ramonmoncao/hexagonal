package com.ramonmoncao.hexagonal.adapters.out.client.mapper;

import com.ramonmoncao.hexagonal.adapters.out.client.response.AddressResponse;
import com.ramonmoncao.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
