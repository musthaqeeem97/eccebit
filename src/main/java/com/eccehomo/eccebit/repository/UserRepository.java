package com.eccehomo.eccebit.repository;

import com.eccehomo.eccebit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

}