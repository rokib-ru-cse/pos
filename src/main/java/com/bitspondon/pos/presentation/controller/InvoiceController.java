package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.InvoiceService;
import com.bitspondon.pos.domain.entities.Invoice;
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
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/list")
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping
    public ResponseEntity<Invoice> getInvoiceById(@RequestParam Long invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);

        return invoice != null ? ResponseEntity.ok(invoice) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice createdInvoice = invoiceService.createInvoice(invoice);
        return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Invoice> updateInvoice(@RequestParam Long invoiceId, @RequestBody Invoice invoiceDetails) {
        Invoice updatedInvoice = invoiceService.updateInvoice(invoiceId, invoiceDetails);

        return updatedInvoice != null ? ResponseEntity.ok(updatedInvoice) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteInvoice(@RequestParam Long invoiceId) {
        invoiceService.deleteInvoice(invoiceId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}