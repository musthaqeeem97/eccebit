package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.dto.PaymentResponse;
import com.eccehomo.eccebit.enums.PaymentApp;
import com.eccehomo.eccebit.model.PaymentOrder;
import com.eccehomo.eccebit.model.User;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

    PaymentOrder createOrder(User user, Long amount, PaymentApp paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean ProccedPaymentOrder (PaymentOrder paymentOrder,
                                 String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user,
                                              Long Amount,
                                              Long orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLink(User user, Long Amount,
                                            Long orderId) throws StripeException;
}

