package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.OrderItemService;
import com.bitspondon.pos.domain.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@RestController
@RequestMapping("/api/order-item")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/list")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping
    public ResponseEntity<OrderItem> getOrderItemById(@RequestParam Long itemId) {
        OrderItem orderItem = orderItemService.getOrderItemById(itemId);

        return orderItem != null ? ResponseEntity.ok(orderItem) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);

        return new ResponseEntity<>(createdOrderItem, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<OrderItem> updateOrderItem(@RequestParam Long itemId, @RequestBody OrderItem orderItemDetails) {
        OrderItem updatedOrderItem = orderItemService.updateOrderItem(itemId, orderItemDetails);

        return updatedOrderItem != null ? ResponseEntity.ok(updatedOrderItem) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteOrderItem(@RequestParam Long itemId) {
        orderItemService.deleteOrderItem(itemId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}