package org.example.account;

import org.example.user.User;
import java.time.LocalDate;
import java.util.List;

public class CreditAccount extends Account {

    private static final String CREDIT = "CREDIT";
    private static final double INTEREST_RATE = -0.05;


    public CreditAccount(Long id, String accountName, String accountNumber, String iban, LocalDate openingDate, Double balance, User user, List<AccountHistory> accountHistories) {
        this.setId(id);
        this.setAccountName(accountName);
        this.setAccountType(CREDIT);
        this.setAccountNumber(accountNumber);
        this.setIban(iban);
        this.setOpeningDate(openingDate);
        this.setBalance(balance);
        this.setUser(user);
        this.setAccountHistories(accountHistories);
    }

    public void applyInterest() {
        double interest = getBalance() * INTEREST_RATE;
        setBalance(getBalance() + interest);
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + getId() +
                ", accountName='" + getAccountName() + '\'' +
                ", accountNumber='" + getAccountNumber() + '\'' +
                ", iban='" + getIban() + '\'' +
                ", openingDate=" + getOpeningDate() +
                ", balance=" + getBalance() +
                ", user=" + getUser() +
                ", accountType='" + getAccountType() + '\'' +
                '}';
    }
}
