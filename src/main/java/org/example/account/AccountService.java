package org.example.account;

import org.example.user.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class AccountService extends Account {

    List<Account> accountList;
    List<AccountHistory> accountHistories;
    int accountQuantity = 0;
    double minAccountBalance = 1000.0;
    int minCreditScore = 60;
    int minAccountHistory = 6;

    public AccountService() {
        this.accountList = new ArrayList<>();
        this.accountHistories = new ArrayList<>();
    }

    // It would be better to call the method from this class.
    private String generateAccountNumber() {

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            stringBuilder.append(random.nextInt(10));
        }

        return stringBuilder.toString();

    }

    public Account displayAccountDetails(long id) {
        for (Account account : accountList) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public String moneyTransfer(String senderAccount, String receivingAccount, double transferAmount, String transferType, String description) {

        Account sender = findAccountById(senderAccount);
        Account receiver = findAccountById(receivingAccount);

        if (sender == null || receiver == null) {

            return "Sender or Receiver account not found!";

        } else if (sender.getBalance() < transferAmount) {

            return "Your balance is insufficient!";

        } else {

            sender.setBalance(sender.getBalance() - transferAmount);
            receiver.setBalance(receiver.getBalance() + transferAmount);

            LocalDate transactionDate = LocalDate.now();

            accountHistories.add(new AccountHistory(sender.getId(), sender, receiver, transferAmount, transferType, description, transactionDate));

            return "Money transfer was completed successfully!";
        }

    }

    private Account findAccountById(String accountNumber) {

        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;

    }

    public List<Account> listAllAccounts() {
        if (accountList == null) {
            return null;
        }
        return accountList;
    }

    public String displayTransactionHistory(Account account) {
        StringBuilder transactionHistory = new StringBuilder("Transaction History for Account " + account.getAccountNumber() + "\n");
        boolean foundTransactions = false;
        for (AccountHistory history : accountHistories) {
            if (history.getId().equals(account.getId())) {
                transactionHistory.append("Sender: " + history.getSender().getAccountNumber() + "\n");
                transactionHistory.append("Receiver: " + history.getReceiver().getAccountNumber() + "\n");
                transactionHistory.append("Amount: " + history.getAmount() + "\n");
                transactionHistory.append("Transfer Type: " + history.getTransferType() + "\n");
                transactionHistory.append("Description: " + history.getDescription() + "\n");
                transactionHistory.append("Transaction Date: " + history.getTransactionDate() + "\n");
                foundTransactions = true;
            }
        }
        if (!foundTransactions) {
            transactionHistory.append("No transactions found for this account.");
        }
        return transactionHistory.toString();


    }

    public String checkLoanEligibility(User user, Account account) {

        boolean isEligible = loanEligibility(user.getTotalBalance(), user.getCreditScore(), getAccountHistoryMonths(account.getOpeningDate()));

        if (isEligible) {
            return "Congratulations! You are eligible for a loan.";
        } else {
            return "Sorry, you are not eligible for a loan. Please see the reasons below:\n" + provideFeedback(user.getTotalBalance(), user.getCreditScore(), getAccountHistoryMonths(account.getOpeningDate()));
        }
    }

    private boolean loanEligibility(double balance, int creditScore, int accountHistory) {
        return balance >= minAccountBalance && creditScore >= minCreditScore && accountHistory >= minAccountHistory;
    }

    private int getAccountHistoryMonths(LocalDate openingDate) {

        Period period = Period.between(openingDate, LocalDate.now());
        return period.getYears() * 12 + period.getMonths();
    }

    private String provideFeedback(double balance, int creditScore, int accountHistory) {

        if (balance < minAccountBalance) {
            return "Your account balance is too low. Minimum required balance is $" + minAccountBalance + "\n";
        }
        if (creditScore < minCreditScore) {
            return "Your credit score is too low. Minimum required credit score is " + minCreditScore + "\n";
        }
        if (accountHistory < minAccountHistory) {
            return "Your account history is too short. Minimum required account history is " + minAccountHistory + " months\n";
        }

        return "Congratulations! You are eligible for a loan.";
    }

    public Double manageBalance(String accountNumber, Double amount) {
        Account foundAccount = null;
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                foundAccount = account;
                break;
            }
        }
        if (foundAccount == null) {
            throw new RuntimeException("Account with number" + accountNumber + "not found");
        }
        if (amount <= 0) {
            throw new RuntimeException("The amount to be deposit should be greater than zero.");
        }
        Double newBalance = foundAccount.getBalance() + amount;
        foundAccount.setBalance(newBalance);

        AccountHistory history = new AccountHistory();
        history.setSender(foundAccount);
        history.setReceiver(null);
        history.setAmount(amount);
        history.setTransferType("Deposit");
        history.setDescription("Balance updated by depositing amount");
        history.setTransactionDate(LocalDate.now());

        accountHistories.add(history);

        return newBalance;
    }

    public void createAccount(Long id, String accountName, String accountType, String accountNumber, String iban, LocalDate openingDate, Double balance, User user) {
        Account newAccount = new Account();
        newAccount.setId(id);
        newAccount.setAccountName(accountName);
        newAccount.setAccountType(accountType);
        newAccount.setAccountNumber(accountNumber);
        newAccount.setIban(iban);
        newAccount.setOpeningDate(openingDate);
        newAccount.setBalance(balance);

        accountList.add(newAccount);
        accountQuantity++;
    }

    public Account getAccountById(Long id) {
        for (Account account : accountList) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public String updateAccount(Long id, String accountName, String accountType, String accountNumber, String iban, LocalDate openingDate, Double balance) {
        Account accountToUpdate = getAccountById(id);
        if (accountToUpdate != null) {
            accountToUpdate.setAccountName(accountName);
            accountToUpdate.setAccountType(accountType);
            accountToUpdate.setAccountNumber(accountNumber);
            accountToUpdate.setIban(iban);
            accountToUpdate.setOpeningDate(openingDate);
            accountToUpdate.setBalance(balance);
            return "Account Updated Successfully";
        }
        return "Account Not Found";
    }

    public String deleteAccount(Long id) {
        Account accountToDelete = getAccountById(id);
        if (accountToDelete != null) {
            accountList.remove(accountToDelete);
            return "Account Deleted Successfully";
        }
        return "Account Not Found";
    }

    public String confirmBeforeDeletingAccount(long id, boolean isDeleting){

        if (!isDeleting){
            return "Deletion canceled!";
        } else {

            //deleteAccount(id);
            return "Deletion completed!";

        }

    }

    public String displayLoanApplicationStatus(Long id, int creditScore, int balance, int accountHistory) {
        if (Objects.equals(id, getUser().getId()) && id != null) {
            if (balance < minAccountBalance || creditScore < minCreditScore || accountHistory < minAccountHistory) {
                return "Account ID: " + getId() + "\n" + "Loan Status: Rejected";
            } else if (balance < minAccountBalance &&  creditScore> minCreditScore && accountHistory > minAccountHistory){
                return "Account ID: " + getId() + "\n" + "Loan Status: Pending" ;
            }else {
                return "Account ID: " + getId() + "\n" + "Loan Status: Approved.";
            }
        }
    return null;
    }
}