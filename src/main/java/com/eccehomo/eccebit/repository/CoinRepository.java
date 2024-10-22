package com.eccehomo.eccebit.repository;

import com.eccehomo.eccebit.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin,String> {
}

