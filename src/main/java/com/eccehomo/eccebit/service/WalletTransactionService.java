package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.enums.WalletTransactionType;
import com.eccehomo.eccebit.model.Wallet;
import com.eccehomo.eccebit.model.WalletTransaction;

import java.util.List;

public interface WalletTransactionService {

    WalletTransaction createTransaction(Wallet wallet,
                                        WalletTransactionType type,
                                        String transferId,
                                        String purpose,
                                        Long amount
    );

    List<WalletTransaction> getTransactions(Wallet wallet, WalletTransactionType type);
}
