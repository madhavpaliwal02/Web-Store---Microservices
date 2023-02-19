package com.micro.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.micro.orderservice.dto.OrderLineItemsDto;
import com.micro.orderservice.dto.OrderRequest;
import com.micro.orderservice.model.Order;
import com.micro.orderservice.model.OrderLineItems;
import com.micro.orderservice.repository.OrderRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);
        orderRepo.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();

        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }
}
