package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.OrderService;
import com.bitspondon.pos.domain.entities.Order;
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
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping
    public ResponseEntity<Order> getOrderById(@RequestParam Long orderId) {
        Order order = orderService.getOrderById(orderId);

        return order != null ? ResponseEntity.ok(order) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);

        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestParam Long orderId, @RequestBody Order orderDetails) {
        Order updatedOrder = orderService.updateOrder(orderId, orderDetails);

        return updatedOrder != null ? ResponseEntity.ok(updatedOrder) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteOrder(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
