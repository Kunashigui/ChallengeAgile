package com.challenge.agileenginechallenge.service.impl;

import com.challenge.agileenginechallenge.dto.OrderDTO;
import com.challenge.agileenginechallenge.exception.ProductNotFoundException;
import com.challenge.agileenginechallenge.model.Order;
import com.challenge.agileenginechallenge.repository.OrderRepository;
import com.challenge.agileenginechallenge.service.OrderService;
import com.challenge.agileenginechallenge.utils.mappers.OrderItemMapper;
import com.challenge.agileenginechallenge.utils.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;

    @Override
    public List<OrderDTO> getOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toOrderDTO).toList();
    }

    @Override
    public OrderDTO getOrderById(UUID id) {
        return orderRepository.findById(id).map(orderMapper::toOrderDTO)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return orderMapper.toOrderDTO(orderRepository.save(orderMapper.toOrder(orderDTO)));
    }

    @Override
    public OrderDTO updateOrder(UUID id, OrderDTO orderDTO) {

        Order order =  orderRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        order.setCustomerName(orderDTO.getCustomerName());
        order.setCustomerEmail(orderDTO.getCustomerEmail());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setItems(orderItemMapper.toOrderItemList(orderDTO.getItems()));
        return orderMapper.toOrderDTO(orderRepository.save(order));
    }

    @Override
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }
}
