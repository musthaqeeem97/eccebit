package com.eccehomo.eccebit.dto;

import lombok.Data;

@Data
public class ResetPasswordRequest {

    private String password;
    private String otp;
}