package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.enums.OrderType;
import com.eccehomo.eccebit.model.Coin;
import com.eccehomo.eccebit.model.Order;
import com.eccehomo.eccebit.model.OrderItem;
import com.eccehomo.eccebit.model.User;

import java.util.List;

public interface OrderService {


    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId);

    List<Order> getAllOrdersForUser(Long userId, String orderType, String assetSymbol);

    void cancelOrder(Long orderId);

//    Order buyAsset(CreateOrderRequest req, Long userId, String jwt) throws Exception;

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;

//    Order sellAsset(CreateOrderRequest req,Long userId,String jwt) throws Exception;



}
