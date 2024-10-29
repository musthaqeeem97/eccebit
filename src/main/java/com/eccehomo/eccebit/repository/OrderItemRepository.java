package com.eccehomo.eccebit.repository;


import com.eccehomo.eccebit.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
