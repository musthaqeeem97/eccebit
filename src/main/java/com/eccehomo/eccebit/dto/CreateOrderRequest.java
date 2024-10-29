package com.eccehomo.eccebit.dto;

import com.eccehomo.eccebit.enums.OrderType;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class CreateOrderRequest {
        private String coinId;
        private double quantity;
        private OrderType orderType;


}
