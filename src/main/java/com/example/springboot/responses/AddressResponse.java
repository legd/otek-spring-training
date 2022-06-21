package com.example.springboot.responses;

import com.example.springboot.dtos.AddressDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AddressResponse {

    private AddressDTO address;
    private List<AddressDTO> addreses;
}
