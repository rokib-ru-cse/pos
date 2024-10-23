package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Invoice;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class InvoiceValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Invoice.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Invoice invoice = (Invoice) target;
        if (invoice.getInvoiceNumber() == null || invoice.getInvoiceNumber().isEmpty()) {
            errors.rejectValue("invoiceNumber", "invoiceNumber.empty", "Invoice number must not be empty");
        }
        if (invoice.getTotalAmount() == null || invoice.getTotalAmount().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("totalAmount", "totalAmount.invalid", "Total amount must be greater than zero");
        }
        if (invoice.getOrder() == null) {
            errors.rejectValue("order", "order.empty", "Order must not be null");
        }
    }
}
