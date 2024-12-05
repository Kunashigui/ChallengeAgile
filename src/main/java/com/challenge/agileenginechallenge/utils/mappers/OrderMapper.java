package com.challenge.agileenginechallenge.utils.mappers;

import com.challenge.agileenginechallenge.dto.OrderDTO;
import com.challenge.agileenginechallenge.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);
}
