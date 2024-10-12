package org.example.user;

import org.example.account.Account;

import java.time.LocalDate;
import java.util.List;

public class User {

    private Long id;

    private String fullName;

    private String password;

    private String email;

    private String identityNumber;

    private LocalDate birthDate;

    private String adress;

    private String phoneNumber;

    private String customerNumber;

    private Double totalBalance;

    private Double salary;

    private List<Account> accounts; // User's accounts

    private int creditScore;

    // Constructor

    public User(Long id, String fullName, String password, String email, String identityNumber, LocalDate birthDate,
                String adress, String phoneNumber, String customerNumber, Double totalBalance, Double salary, List<Account> accounts, int creditScore) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.identityNumber = identityNumber;
        this.birthDate = birthDate;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.customerNumber = customerNumber;
        this.totalBalance = totalBalance;
        this.accounts = accounts;
        this.salary = salary;
        this.creditScore = creditScore;
    }

    public User() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword(){ return password;}

    public void setPassword(){this.password=password;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAdress(){return adress;}

    public void setAdress(String adress){this.adress=adress;}

    public String getPhoneNumber(){return phoneNumber;}

    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Double getSalary(){return salary;}

    public void setSalary(Double salary){ this.salary=salary;}

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

}