package com.bitspondon.pos.application.service;

import com.bitspondon.pos.application.repository.InvoiceRepository;
import com.bitspondon.pos.domain.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice createInvoice(Invoice invoice) {
        invoice.setCreatedAt(LocalDateTime.now());
        invoice.setInvoiceDate(LocalDateTime.now());
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Invoice invoice = getInvoiceById(id);
        if (invoice != null) {
            invoice.setInvoiceNumber(invoiceDetails.getInvoiceNumber());
            invoice.setTotalAmount(invoiceDetails.getTotalAmount());
            invoice.setOrder(invoiceDetails.getOrder());
            return invoiceRepository.save(invoice);
        }
        return null;
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
