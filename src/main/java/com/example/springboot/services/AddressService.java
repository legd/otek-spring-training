package com.example.springboot.services;

import com.example.springboot.dbmodels.Address;
import com.example.springboot.dtos.AddressDTO;
import com.example.springboot.repositories.IAddressRepository;
import com.example.springboot.requests.CreateAddressRequest;
import com.example.springboot.responses.AddressResponse;
import com.example.springboot.responses.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final IAddressRepository addressRepository;

    public AddressResponse get() {
        List<AddressDTO> addressToList = new ArrayList<>();
        List<Address> addresses = addressRepository.findAll();
        AddressResponse.AddressResponseBuilder response = AddressResponse.builder();
        for (Address address: addresses) {
            addressToList.add(address.transformToDTO());
        }
        return response.addreses(addressToList).build();
    }

    public AddressResponse create(CreateAddressRequest newAddress) {
        AddressResponse.AddressResponseBuilder response = AddressResponse.builder();
        Address addedAddress = addressRepository.save(newAddress.transformToEntity());
        return response.address(addedAddress.transformToDTO()).build();
    }
}
