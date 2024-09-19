package com.Studen.Startup.Repository;

import com.Studen.Startup.Student;
import com.Studen.Startup.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
