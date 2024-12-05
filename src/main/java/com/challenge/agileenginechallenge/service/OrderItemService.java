package com.challenge.agileenginechallenge.service;

import com.challenge.agileenginechallenge.dto.OrderItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface OrderItemService {

    public List<OrderItemDTO> getOrderItems();
    public OrderItemDTO getOrderItemById(UUID id);
    public OrderItemDTO createOrderItem(OrderItemDTO orderItem);
    public OrderItemDTO updateOrderItem(UUID id, OrderItemDTO orderItem);
    public void deleteOrderItem(UUID id);
}
