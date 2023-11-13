package com.mateudev.orderservice.service;

import com.mateudev.orderservice.dto.OrderLineItemsDto;
import com.mateudev.orderservice.dto.OrderRequest;
import com.mateudev.orderservice.model.Order;
import com.mateudev.orderservice.model.OrderLineItems;
import com.mateudev.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());


       List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDto()
                .stream()
                .map(this::mapToDto)
                .toList();
            order.setOrderLineItensList(orderLineItems);

            orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return  null;
    }
}
