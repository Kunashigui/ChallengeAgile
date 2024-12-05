package com.challenge.agileenginechallenge.service;

import com.challenge.agileenginechallenge.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface OrderService {

    List<OrderDTO> getOrders();
    OrderDTO getOrderById(UUID id);
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(UUID id, OrderDTO orderDTO);
    void deleteOrder(UUID id);
}
