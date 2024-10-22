package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.exception.WalletException;
import com.eccehomo.eccebit.model.Order;
import com.eccehomo.eccebit.model.User;
import com.eccehomo.eccebit.model.Wallet;

public interface WalletService {


    Wallet getUserWallet(User user) throws WalletException;

    public Wallet addBalanceToWallet(Wallet wallet, Long money) throws WalletException;

    public Wallet findWalletById(Long id) throws WalletException;

    public Wallet walletToWalletTransfer(User sender,Wallet receiverWallet, Long amount) throws WalletException;

    public Wallet payOrderPayment(Order order, User user) throws WalletException;



}
