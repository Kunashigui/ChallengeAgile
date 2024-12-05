package com.challenge.agileenginechallenge.service;

import com.challenge.agileenginechallenge.dto.OrderItemDTO;
import com.challenge.agileenginechallenge.model.OrderItem;
import com.challenge.agileenginechallenge.repository.OrderItemRepository;
import com.challenge.agileenginechallenge.service.impl.OrderItemServiceImpl;
import com.challenge.agileenginechallenge.utils.mappers.OrderItemMapper;
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
class OrderItemServiceTest {

    @Mock
    OrderItemRepository orderItemRepository;

    @Mock
    OrderItemMapper orderItemMapper;

    @InjectMocks
    OrderItemServiceImpl orderItemService;

    @BeforeEach
    void setUp() {
        Mockito.when(orderItemRepository.findAll()).thenReturn(List.of(new OrderItem()));
        Mockito.when(orderItemRepository.save(any())).thenReturn(new OrderItem());

        Mockito.when(orderItemMapper.toOrderItemDTO(any())).thenReturn(new OrderItemDTO());
        Mockito.when(orderItemMapper.toOrderItem(any())).thenReturn(new OrderItem());
    }

    @Test
    void getOrderItems() {
            List<OrderItemDTO> orderItemDTOList = orderItemService.getOrderItems();
            assertEquals(1, orderItemDTOList.size());
    }

    @Test
    void getOrderItemById() {
        UUID id = UUID.randomUUID();
        Mockito.when(orderItemRepository.findById(id)).thenReturn(Optional.of(new OrderItem()));

        OrderItemDTO orderItemDTO = orderItemService.getOrderItemById(id);
        assertNotNull(orderItemDTO);
    }

    @Test
    void getOrderItemByIdNotFound() {
        Mockito.when(orderItemRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> orderItemService.getOrderItemById(any()));
    }

    @Test
    void createOrderItem() {
        OrderItemDTO orderItemDTO = orderItemService.createOrderItem(new OrderItemDTO());
        assertNotNull(orderItemDTO);
    }

    @Test
    void updateOrderItem() {
        Mockito.when(orderItemRepository.findById(any())).thenReturn(Optional.of(new OrderItem()));
        OrderItemDTO orderItemDTO = orderItemService.updateOrderItem(any(), new OrderItemDTO());
        assertNotNull(orderItemDTO);
    }

    @Test
    void updateOrderItemNotFound() {
        Mockito.when(orderItemRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> orderItemService.updateOrderItem(any(), new OrderItemDTO()));
    }

    @Test
    void deleteOrderItem() {
        orderItemService.deleteOrderItem(any());
        Mockito.verify(orderItemRepository, Mockito.times(1)).deleteById(any());
    }
}