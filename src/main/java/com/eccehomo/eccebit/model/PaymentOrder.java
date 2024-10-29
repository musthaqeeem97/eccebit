package com.eccehomo.eccebit.model;


import com.eccehomo.eccebit.enums.PaymentApp;
import com.eccehomo.eccebit.enums.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;

    private PaymentOrderStatus status = PaymentOrderStatus.PENDING;

    private PaymentApp paymentApp;

    @ManyToOne
    private User user;
}
