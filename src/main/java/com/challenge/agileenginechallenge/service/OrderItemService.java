package com.challenge.agileenginechallenge.service;

import com.challenge.agileenginechallenge.dto.OrderItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface OrderItemService {

    List<OrderItemDTO> getOrderItems();
    OrderItemDTO getOrderItemById(UUID id);
    OrderItemDTO createOrderItem(OrderItemDTO orderItem);
    OrderItemDTO updateOrderItem(UUID id, OrderItemDTO orderItem);
    void deleteOrderItem(UUID id);
}
