package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.enums.WalletTransactionType;
import com.eccehomo.eccebit.model.Wallet;
import com.eccehomo.eccebit.model.WalletTransaction;
import com.eccehomo.eccebit.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class WalletTransactionServiceImplementation implements  WalletTransactionService{

    @Autowired
    private WalletTransactionRepository walletTransactionRepository;


    @Override
    public WalletTransaction createTransaction(Wallet wallet,
                                               WalletTransactionType type,
                                               String transferId,
                                               String purpose,
                                               Long amount
    ) {
        WalletTransaction transaction = new WalletTransaction();
        transaction.setWallet(wallet);
        transaction.setDate(LocalDate.now());
        transaction.setType(type);
        transaction.setTransferId(transferId);
        transaction.setPurpose(purpose);
        transaction.setAmount(amount);

        return walletTransactionRepository.save(transaction);
    }

    @Override
    public List<WalletTransaction> getTransactions(Wallet wallet, WalletTransactionType type) {
        return walletTransactionRepository.findByWalletOrderByDateDesc(wallet);
    }

}
