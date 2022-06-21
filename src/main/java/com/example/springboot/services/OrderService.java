package com.example.springboot.services;

import com.example.springboot.dbmodels.Address;
import com.example.springboot.dbmodels.Order;
import com.example.springboot.dbmodels.OrderProduct;
import com.example.springboot.dbmodels.Product;
import com.example.springboot.dtos.OrderDTO;
import com.example.springboot.repositories.IAddressRepository;
import com.example.springboot.repositories.IOrderProductRepository;
import com.example.springboot.repositories.IOrderRepository;
import com.example.springboot.repositories.IProductRepository;
import com.example.springboot.requests.CreateOrderRequest;
import com.example.springboot.requests.CreateOrderProductRequest;
import com.example.springboot.requests.UpdateOrderRequest;
import com.example.springboot.responses.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final IOrderProductRepository ordersProductRepository;
    private final IOrderRepository ordersRepository;
    private final IProductRepository productsRepository;

    private final IAddressRepository addressRepository;

    public OrderResponse get() {
        List<OrderDTO> ordersToList = new ArrayList<>();
        OrderResponse.OrderResponseBuilder response = OrderResponse.builder();

        List<Order> orders = ordersRepository.findAll();
        for (Order order: orders) {
            ordersToList.add(order.transformToDTO());
        }

        return response.orders(ordersToList).build();
    }

    @Transactional
    public OrderResponse create(CreateOrderRequest newOrder) {
        Optional<Address> address = addressRepository.findById(newOrder.getDeliveryAddress());
        OrderResponse.OrderResponseBuilder response = OrderResponse.builder();
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setStatus("Pending");
        order.setPaymentMethod(newOrder.getPaymentMethod());
        order.setDeliveryAddress(address.get());
        order = ordersRepository.save(order);
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (CreateOrderProductRequest orderProduct : newOrder.getOrderProducts()) {
            Optional<Product> product = productsRepository.findById(orderProduct.getProductId());
            orderProducts.add(ordersProductRepository.save(OrderProduct.builder().order(order).product(product.get())
                    .quantity(orderProduct.getQuantity()).build()));
        }

        order.setOrderProducts(orderProducts);
        Order orderUpdated = ordersRepository.save(order);
        return response.order(orderUpdated.transformToDTO()).build();
    }

    public OrderResponse update(UpdateOrderRequest updateOrder) {
        OrderResponse.OrderResponseBuilder response = OrderResponse.builder();
        Optional<Order> order = ordersRepository.findById(updateOrder.getId());
        order.get().setStatus(updateOrder.getStatus());
        ordersRepository.save(order.get());
        return response.order(order.get().transformToDTO()).build();
    }
}
