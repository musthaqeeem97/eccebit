package com.eccehomo.eccebit.controller;

import com.eccehomo.eccebit.dto.PaymentResponse;
import com.eccehomo.eccebit.enums.PaymentApp;
import com.eccehomo.eccebit.exception.UserException;
import com.eccehomo.eccebit.model.PaymentOrder;
import com.eccehomo.eccebit.model.User;
import com.eccehomo.eccebit.service.PaymentService;
import com.eccehomo.eccebit.service.UserService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class PaymentController {

        @Autowired
        private UserService userService;

        @Autowired
        private PaymentService paymentService;



        @PostMapping("/api/payment/{paymentApp}/amount/{amount}")
        public ResponseEntity<PaymentResponse> paymentHandler(
                @PathVariable PaymentApp paymentApp,
                @PathVariable Long amount,
                @RequestHeader("Authorization") String jwt) throws UserException, RazorpayException, StripeException {

            User user = userService.findUserProfileByJwt(jwt);

            PaymentResponse paymentResponse;

            PaymentOrder order= paymentService.createOrder(user, amount,paymentApp);

            if(paymentApp.equals(PaymentApp.RAZORPAY)){
                paymentResponse=paymentService.createRazorpayPaymentLink(user,amount,
                        order.getId());
            }
            else{
                paymentResponse=paymentService.createStripePaymentLink(user,amount, order.getId());
            }

            return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
        }


    }


