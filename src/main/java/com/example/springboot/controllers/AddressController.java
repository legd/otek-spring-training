package com.example.springboot.controllers;

import com.example.springboot.requests.CreateAddressRequest;
import com.example.springboot.responses.AddressResponse;
import com.example.springboot.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Validated
@RestController
public class AddressController {
    private final AddressService addressService;

    @GetMapping("api/addresses/list")
    public ResponseEntity<AddressResponse> get() {
        return ResponseEntity.ok(addressService.get());
    }

    @PostMapping("api/addresses/create")
    public ResponseEntity<AddressResponse> create(@Valid @RequestBody CreateAddressRequest newAddress) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(newAddress));
    }
}
