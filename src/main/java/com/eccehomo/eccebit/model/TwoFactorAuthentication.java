package com.eccehomo.eccebit.model;


import com.eccehomo.eccebit.enums.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuthentication {

    private boolean isEnabled = false;
    private VerificationType type;

}
