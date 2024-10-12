package org.example.account;

import org.example.user.User;

import java.time.LocalDate;
import java.util.List;

public class Account {

    private Long id;

    private String accountName;

    private String accountType;

    private String accountNumber;

    private String iban;

    private LocalDate openingDate;

    private Double balance;

    private User user; // Who does this account belong to?

    private List<AccountHistory> accountHistories;


    // Constructors

    public Account(Long id, String accountName, String accountType, String accountNumber, String iban, LocalDate openingDate, Double balance, User user, List<AccountHistory> accountHistories) {
        this.id = id;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.iban = iban;
        this.openingDate = openingDate;
        this.balance = balance;
        this.user = user;
        this.accountHistories = accountHistories;

    }



    public Account() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AccountHistory> getAccountHistories() {
        return accountHistories;
    }

    public void setAccountHistories(List<AccountHistory> accountHistories) {
        this.accountHistories = accountHistories;
    }

}