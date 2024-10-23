package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.PaymentService;
import com.bitspondon.pos.domain.entities.Payment;
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
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/list")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping
    public ResponseEntity<Payment> getPaymentById(@RequestParam Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);

        return payment != null ? ResponseEntity.ok(payment) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);

        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Payment> updatePayment(@RequestParam Long paymentId, @RequestBody Payment paymentDetails) {
        Payment updatedPayment = paymentService.updatePayment(paymentId, paymentDetails);

        return updatedPayment != null ? ResponseEntity.ok(updatedPayment) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deletePayment(@RequestParam Long paymentId) {
        paymentService.deletePayment(paymentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}