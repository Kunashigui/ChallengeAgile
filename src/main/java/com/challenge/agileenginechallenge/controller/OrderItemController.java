package com.challenge.agileenginechallenge.controller;

import com.challenge.agileenginechallenge.dto.OrderItemDTO;
import com.challenge.agileenginechallenge.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    OrderItemService orderItemService;

    @GetMapping
    public List<OrderItemDTO> getOrderItems() {
        return orderItemService.getOrderItems();
    }

    @GetMapping("/{id}")
    public OrderItemDTO getOrderItemById(@PathVariable String id) {
        return orderItemService.getOrderItemById(UUID.fromString(id));
    }

    @PostMapping
    public OrderItemDTO createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.createOrderItem(orderItemDTO);
    }

    @PutMapping("/{id}")
    public OrderItemDTO updateOrderItem(@PathVariable String id, @RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.updateOrderItem(UUID.fromString(id), orderItemDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable String id) {
        orderItemService.deleteOrderItem(UUID.fromString(id));
    }
}
