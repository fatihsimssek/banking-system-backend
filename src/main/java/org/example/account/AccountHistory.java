package org.example.account;

import java.time.LocalDate;

public class AccountHistory {

    private Long id;

    private Account sender;

    private Account receiver;

    private Double amount;

    private String transferType;

    private String description;

    private LocalDate transactionDate;

    // Constructors

    public AccountHistory(Long id, Account sender, Account receiver, Double amount, String transferType, String description, LocalDate transactionDate) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.transferType = transferType;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public AccountHistory() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

}
