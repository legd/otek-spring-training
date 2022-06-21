package com.example.springboot.controllers;

import com.example.springboot.requests.CreateOrderRequest;
import com.example.springboot.requests.UpdateOrderRequest;
import com.example.springboot.responses.OrderResponse;
import com.example.springboot.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Validated
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("api/orders/list")
    public ResponseEntity<OrderResponse> get() {
        return ResponseEntity.ok(orderService.get());
    }

    @PostMapping("api/orders/create")
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody CreateOrderRequest newOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(newOrder));
    }

    @PutMapping("api/orders/update")
    public ResponseEntity<OrderResponse> update(@Valid @RequestBody UpdateOrderRequest order) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.update(order));
    }
}
