package com.challenge.agileenginechallenge.utils.mappers;

import com.challenge.agileenginechallenge.dto.OrderItemDTO;
import com.challenge.agileenginechallenge.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {


    @Mappings({
            @Mapping(source = "order.id", target = "orderId"),
            @Mapping(source = "product.id", target = "productId")
    })
    OrderItemDTO toOrderItemDTO(OrderItem orderItem);

    @Mappings({
            @Mapping(source = "orderId", target = "order.id"),
            @Mapping(source = "productId", target = "product.id")
    })
    OrderItem toOrderItem(OrderItemDTO orderItemDTO);

    List<OrderItem> toOrderItemList(List<OrderItemDTO> orderItemDTOs);
    List<OrderItemDTO> toOrderItemDTOList(List<OrderItem> orderItems);
}
