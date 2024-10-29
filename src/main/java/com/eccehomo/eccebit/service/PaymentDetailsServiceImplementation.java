package com.eccehomo.eccebit.service;


import com.eccehomo.eccebit.model.PaymentDetails;
import com.eccehomo.eccebit.model.User;
import com.eccehomo.eccebit.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentDetailsServiceImplementation implements PaymentDetailsService{



    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user
    ) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAccountNumber(accountNumber);
        paymentDetails.setAccountHolderName(accountHolderName);
        paymentDetails.setIfsc(ifsc);
        paymentDetails.setBankName(bankName);
        paymentDetails.setUser(user);
        return paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public PaymentDetails getUsersPaymentDetails(User user) {
        return paymentDetailsRepository.getPaymentDetailsByUserId(user.getId());
    }

}
