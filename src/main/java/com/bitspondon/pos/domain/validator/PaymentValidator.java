package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Payment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class PaymentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Payment.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Payment payment = (Payment) target;
        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("amount", "amount.invalid", "Amount must be greater than zero");
        }
        if (payment.getPaymentMethod() == null || payment.getPaymentMethod().isEmpty()) {
            errors.rejectValue("paymentMethod", "paymentMethod.empty", "Payment method must not be empty");
        }
        if (payment.getStatus() == null || payment.getStatus().isEmpty()) {
            errors.rejectValue("status", "status.empty", "Status must not be empty");
        }
        if (payment.getInvoice() == null) {
            errors.rejectValue("invoice", "invoice.empty", "Invoice must not be null");
        }
    }
}
