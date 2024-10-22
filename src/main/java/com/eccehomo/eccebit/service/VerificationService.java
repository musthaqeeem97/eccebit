package com.eccehomo.eccebit.service;


import com.eccehomo.eccebit.enums.VerificationType;
import com.eccehomo.eccebit.model.User;
import com.eccehomo.eccebit.model.VerificationCode;

public interface VerificationService {
    VerificationCode sendVerificationOTP(User user, VerificationType verificationType);

    VerificationCode findVerificationById(Long id) throws Exception;

    VerificationCode findUsersVerification(User user) throws Exception;

    Boolean VerifyOtp(String opt, VerificationCode verificationCode);

    void deleteVerification(VerificationCode verificationCode);
}