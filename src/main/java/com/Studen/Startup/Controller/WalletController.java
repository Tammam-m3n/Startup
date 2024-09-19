package com.Studen.Startup.Controller;

import com.Studen.Startup.Request.StudentRequest;
import com.Studen.Startup.Request.WalletRequest;
import com.Studen.Startup.Service.WalletService;
import com.Studen.Startup.Student;
import com.Studen.Startup.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("add_wallet")
    public ResponseEntity<?> addWallet(@RequestBody WalletRequest walletRequest) {
        return walletService.save(walletRequest);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllWallet() {
        return walletService.getAll();
    }

    @GetMapping("by_id/{id}")
    public ResponseEntity<?> getWalletById(@PathVariable int id) {
        return walletService.findById(id);
    }

    @GetMapping("update")
    public Wallet update(Wallet wallet) {
        return walletService.update(wallet);
    }

    @DeleteMapping("delete_wallet/{id}")
    public void deleteWallet(@PathVariable int id) {
        walletService.deleteById(id);
    }

}
