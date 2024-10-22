package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.enums.VerificationType;
import com.eccehomo.eccebit.model.ForgotPasswordToken;
import com.eccehomo.eccebit.model.User;

public interface ForgotPasswordService {

    ForgotPasswordToken createToken(User user, String id, String otp,
                                    VerificationType verificationType, String sendTo);

    ForgotPasswordToken findById(String id);

    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);

    boolean verifyToken(ForgotPasswordToken token,String otp);
}
