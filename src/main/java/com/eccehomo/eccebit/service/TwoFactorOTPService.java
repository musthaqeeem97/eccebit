package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.model.TwoFactorAuthentication;
import com.eccehomo.eccebit.model.TwoFactorAuthenticationOTP;
import com.eccehomo.eccebit.model.User;

public interface TwoFactorOTPService {

    TwoFactorAuthenticationOTP createTwoFactorOtp(User user, String otp, String jwt);

    TwoFactorAuthenticationOTP findByUser(Long userId);

    TwoFactorAuthenticationOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorAuthenticationOTP twoFactorOtp,String otp);

    void deleteTwoFactorOtp(TwoFactorAuthenticationOTP twoFactorOTP);
}
