package com.eccehomo.eccebit.repository;


import com.eccehomo.eccebit.model.Wallet;
import com.eccehomo.eccebit.model.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,Long> {

    List<WalletTransaction> findByWalletOrderByDateDesc(Wallet wallet);

}
