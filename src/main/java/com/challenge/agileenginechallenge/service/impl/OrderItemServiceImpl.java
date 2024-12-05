package com.challenge.agileenginechallenge.service.impl;

import com.challenge.agileenginechallenge.dto.OrderItemDTO;
import com.challenge.agileenginechallenge.exception.ProductNotFoundException;
import com.challenge.agileenginechallenge.repository.OrderItemRepository;
import com.challenge.agileenginechallenge.service.OrderItemService;
import com.challenge.agileenginechallenge.utils.mappers.OrderItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    OrderItemRepository orderItemRepository;
    OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItemDTO> getOrderItems() {

        return orderItemRepository.findAll().stream().map(orderItemMapper::toOrderItemDTO).collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO getOrderItemById(UUID id) {

        return orderItemRepository.findById(id).map(orderItemMapper::toOrderItemDTO)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public OrderItemDTO createOrderItem(OrderItemDTO orderItem) {

        return orderItemMapper.toOrderItemDTO(orderItemRepository.save(orderItemMapper.toOrderItem(orderItem)));
    }

    @Override
    public OrderItemDTO updateOrderItem(UUID id, OrderItemDTO orderItem) {

        OrderItemDTO orderItemDTO = orderItemMapper.toOrderItemDTO(orderItemRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));

        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setProductId(orderItem.getProductId());
        orderItemDTO.setOrderId(orderItem.getOrderId());

        return orderItemMapper.toOrderItemDTO(orderItemRepository.save(orderItemMapper.toOrderItem(orderItemDTO)));
    }

    @Override
    public void deleteOrderItem(UUID id) {

        orderItemRepository.deleteById(id);
    }
}
