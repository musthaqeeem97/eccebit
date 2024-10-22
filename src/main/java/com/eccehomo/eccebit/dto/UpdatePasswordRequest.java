package com.eccehomo.eccebit.dto;

import com.eccehomo.eccebit.enums.VerificationType;
import lombok.Data;

@Data
public class UpdatePasswordRequest {
    private String sendTo;
    private VerificationType verificationType;
}
