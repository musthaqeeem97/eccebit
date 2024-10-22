package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.model.TwoFactorAuthentication;
import com.eccehomo.eccebit.model.TwoFactorAuthenticationOTP;
import com.eccehomo.eccebit.model.User;
import com.eccehomo.eccebit.repository.TwoFactorOTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TwoFactorOTPServiceImplementation implements TwoFactorOTPService{

    @Autowired
    private TwoFactorOTPRepository twoFactorOtpRepository;

    @Override
    public TwoFactorAuthenticationOTP createTwoFactorOtp(User user, String otp, String jwt) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        TwoFactorAuthenticationOTP twoFactorOTP=new TwoFactorAuthenticationOTP();
        twoFactorOTP.setId(id);
        twoFactorOTP.setUser(user);
        twoFactorOTP.setOtp(otp);
        twoFactorOTP.setJwt(jwt);
        return twoFactorOtpRepository.save(twoFactorOTP);

    }

    @Override
    public TwoFactorAuthenticationOTP findByUser(Long userId) {
        return twoFactorOtpRepository.findByUserId(userId);
    }

    @Override
    public TwoFactorAuthenticationOTP findById(String id) {
        Optional<TwoFactorAuthenticationOTP> twoFactorOtp=twoFactorOtpRepository.findById(id);
        return twoFactorOtp.orElse(null);
    }

    @Override
    public boolean verifyTwoFactorOtp(TwoFactorAuthenticationOTP twoFactorOtp, String otp) {
        return twoFactorOtp.getOtp().equals(otp);
    }

    @Override
    public void deleteTwoFactorOtp(TwoFactorAuthenticationOTP twoFactorOTP) {
        twoFactorOtpRepository.delete(twoFactorOTP);
    }
}
