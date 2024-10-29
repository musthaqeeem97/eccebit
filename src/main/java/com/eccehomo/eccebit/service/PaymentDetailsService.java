package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.model.PaymentDetails;
import com.eccehomo.eccebit.model.User;

public interface PaymentDetailsService {


    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user
    );

    public PaymentDetails getUsersPaymentDetails(User user);
}
