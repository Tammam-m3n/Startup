package com.Studen.Startup.Service;

import com.Studen.Startup.Repository.CourseRepository;
import com.Studen.Startup.Repository.WalletRepository;
import com.Studen.Startup.Request.WalletRequest;
import com.Studen.Startup.Response.StudentResponse;
import com.Studen.Startup.Response.WalletResponse;
import com.Studen.Startup.Student;
import com.Studen.Startup.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<?> save(WalletRequest walletRequest) {

        Wallet wallet = Wallet.builder()
                .bankAccountNumber(walletRequest.getBankAccountNumber())
                .build();
        walletRepository.save(wallet);

        WalletResponse walletResponse = WalletResponse.builder()
                .id(wallet.getId())
                .bankAccountNumber(walletRequest.getBankAccountNumber())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(walletResponse);
    }

    public ResponseEntity<?> getAll() {

        List<Wallet> wallets = walletRepository.findAll();
        List<WalletResponse>  walletResponses = new ArrayList<>();
        for (Wallet wallet : wallets) {
            WalletResponse walletResponse = WalletResponse.builder()
                    .id(wallet.getId())
                    .bankAccountNumber(wallet.getBankAccountNumber())
                    .build();
            walletResponses.add(walletResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(walletResponses);
    }

    public ResponseEntity<?> findById(int id) {
        Wallet wallet = walletRepository.findById(id).orElse(null);
        if (wallet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        WalletResponse walletResponse = WalletResponse.builder()
                .id(wallet.getId())
                .bankAccountNumber(wallet.getBankAccountNumber())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(walletResponse);
    }

    public void deleteById(int id) {
        Wallet wallet = walletRepository.findById(id).orElse(null);
        if (wallet != null) {
            walletRepository.deleteById(id);
        }
    }

    public Wallet update(Wallet wallet) {
        Wallet wall = walletRepository.findById(wallet.getId()).orElse(null);

        if (wall != null) {
            wall.setBankAccountNumber(wallet.getBankAccountNumber());
            walletRepository.save(wall);
        }
        return wall;
    }
}
