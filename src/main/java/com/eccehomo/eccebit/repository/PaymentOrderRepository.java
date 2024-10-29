package com.eccehomo.eccebit.repository;

import com.eccehomo.eccebit.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder,Long> {
}
