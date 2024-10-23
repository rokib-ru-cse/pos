package com.bitspondon.pos.application.service;

import com.bitspondon.pos.application.repository.OrderItemRepository;
import com.bitspondon.pos.domain.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItemDetails) {
        OrderItem orderItem = getOrderItemById(id);
        if (orderItem != null) {
            orderItem.setQuantity(orderItemDetails.getQuantity());
            orderItem.setPrice(orderItemDetails.getPrice());
            orderItem.setProduct(orderItemDetails.getProduct());
            return orderItemRepository.save(orderItem);
        }
        return null;
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
