package com.eccehomo.eccebit.repository;

import com.eccehomo.eccebit.model.TwoFactorAuthenticationOTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwoFactorOTPRepository extends JpaRepository<TwoFactorAuthenticationOTP,String> {

    TwoFactorAuthenticationOTP findByUserId(Long userId);
}

