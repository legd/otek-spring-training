package com.example.springboot.requests;

import com.example.springboot.dbmodels.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAddressRequest {

    private String recipient;
    private String firstLine;
    private String secondLine;
    private String city;
    private String zipCode;

    public Address transformToEntity() {
        return Address.builder().recipient(this.recipient).firstLine(this.firstLine).secondLine(this.secondLine).
                city(this.city).zipCode(this.zipCode).build();
    }
}
