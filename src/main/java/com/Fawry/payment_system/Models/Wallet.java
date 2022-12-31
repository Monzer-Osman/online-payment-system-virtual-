package com.Fawry.payment_system.Models;

import javax.persistence.*;

@Table(name = "wallets")
@Entity
public class Wallet {

    @Id
    @SequenceGenerator(
            name = "walletId_generator",
            sequenceName = "walletId_generator",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "walletId_generator"
    )
    private Integer walletId;
    private int balance = 0;

    public Wallet(Integer walletId, int balance){
        this.walletId = walletId;
        this.balance = balance;
    }

    public Wallet(){}

    public Wallet(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setWalletId(Integer walletId){
        this.walletId = walletId;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void subtractBalanceBy(int amount){
        balance -= amount;
    }

    public void addBalance(int amount){
        balance += amount;
    }

}
