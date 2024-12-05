package com.challenge.agileenginechallenge.service;

import com.challenge.agileenginechallenge.dto.OrderDTO;
import com.challenge.agileenginechallenge.model.Order;
import com.challenge.agileenginechallenge.repository.OrderRepository;
import com.challenge.agileenginechallenge.service.impl.OrderServiceImpl;
import com.challenge.agileenginechallenge.utils.mappers.OrderItemMapper;
import com.challenge.agileenginechallenge.utils.mappers.OrderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    OrderMapper orderMapper;

    @Mock
    OrderItemMapper orderItemMapper;

    @InjectMocks
    OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        Mockito.when(orderRepository.findAll()).thenReturn(List.of(new Order()));
        Mockito.when(orderRepository.save(any())).thenReturn(new Order());

        Mockito.when(orderMapper.toOrderDTO(any())).thenReturn(new OrderDTO());
        Mockito.when(orderMapper.toOrder(any())).thenReturn(new Order());

        Mockito.when(orderItemMapper.toOrderItemList(any())).thenReturn(List.of());
    }

    @Test
    void getOrders() {
        List<OrderDTO> orderDTOList = orderService.getOrders();
        assertEquals(1, orderDTOList.size());
    }

    @Test
    void getOrderById() {
        UUID id = UUID.randomUUID();
        Mockito.when(orderRepository.findById(id)).thenReturn(Optional.of(new Order()));

        OrderDTO orderDTO = orderService.getOrderById(id);
        assertNotNull(orderDTO);
    }

    @Test
    void getOrderByIdNotFound() {
        Mockito.when(orderRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> orderService.getOrderById(any()));
    }

    @Test
    void createOrder() {
        OrderDTO orderDTO = orderService.createOrder(new OrderDTO());
        assertNotNull(orderDTO);
    }

    @Test
    void updateOrder() {
        Mockito.when(orderRepository.findById(any())).thenReturn(Optional.of(new Order()));
        OrderDTO orderDTO = orderService.updateOrder(any(), new OrderDTO());
        assertNotNull(orderDTO);
    }

    @Test
    void updateOrderNotFound() {
        Mockito.when(orderRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> orderService.updateOrder(any(), new OrderDTO()));
    }

    @Test
    void deleteOrder() {
        orderService.deleteOrder(any());
        Mockito.verify(orderRepository, Mockito.times(1)).deleteById(any());
    }
}