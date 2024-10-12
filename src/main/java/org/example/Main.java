package org.example;

import org.example.account.Account;
import org.example.account.AccountService;
import org.example.user.User;
import org.example.user.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("Welcome to our banking application!");
        System.out.println("You can perform the following operations in our application:");
        System.out.println("---------------------------------------");
        System.out.println("--------------------------------------------------------------");
        AccountService accountService = new AccountService();
        Account account = new Account();
        User user = new User(); // create a user object
        UserService userService = new UserService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Account and User Management System");
            System.out.println("1. Account Management");
            System.out.println("2. User Management");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            String choiceStr = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        // Account Management
                        while (true) {
                            System.out.println("Account Management System");
                            System.out.println("1. Create Account");
                            System.out.println("2. Display Account Details");
                            System.out.println("3. List All Accounts");
                            System.out.println("4. Update Account");
                            System.out.println("5. Delete Account");
                            System.out.println("6. Confirm Before Deleting Account");
                            System.out.println("7. Money Transfer");
                            System.out.println("8. Display Transaction History");
                            System.out.println("9. Manage Balance");
                            System.out.println("10. Check Loan Eligibility");
                            System.out.println("11. Display Loan Application Status");
                            System.out.println("12. Back");

                            System.out.print("Enter your choice: ");
                            String accountChoiceStr = scanner.nextLine();
                            int accountChoice;
                            try {
                                accountChoice = Integer.parseInt(accountChoiceStr);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid choice. Please enter a number.");
                                continue;
                            }

                            try {
                                switch (accountChoice) {
                                    case 1:
                                        // Create Account
                                        System.out.print("Enter account ID: ");
                                        String idStr = scanner.nextLine();
                                        Long id = Long.parseLong(idStr);
                                        System.out.print("Enter account name: ");
                                        String accountName = scanner.nextLine();
                                        System.out.print("Enter account type: ");
                                        String accountType = scanner.nextLine();
                                        System.out.print("Enter account number: ");
                                        String accountNumber = scanner.nextLine();
                                        System.out.print("Enter IBAN: ");
                                        String iban = scanner.nextLine();
                                        System.out.print("Enter opening date (yyyy-mm-dd): ");
                                        String openingDateStr = scanner.nextLine();
                                        LocalDate openingDate = LocalDate.parse(openingDateStr);
                                        System.out.print("Enter initial balance: ");
                                        String balanceStr = scanner.nextLine();
                                        Double balance = Double.parseDouble(balanceStr);

                                        accountService.createAccount(id, accountName, accountType, accountNumber, iban, openingDate, balance, new User());
                                        break;

                                    case 2:
                                        // Display Account Details
                                        System.out.print("Enter account ID: ");
                                        idStr = scanner.nextLine();
                                        id = Long.parseLong(idStr);
                                        account = accountService.displayAccountDetails(id);
                                        if (account != null) {
                                            System.out.println("Account details: " + account);
                                        } else {
                                            System.out.println("Account not found!");
                                        }
                                        break;

                                    case 3:
                                        // List All Accounts
                                        List<Account> accounts = accountService.listAllAccounts();
                                        if (accounts != null) {
                                            System.out.println("Accounts: ");
                                            for (Account acc : accounts) {
                                                System.out.println(acc);
                                            }
                                        } else {
                                            System.out.println("No accounts found!");
                                        }
                                        break;

                                    case 4:
                                        // Update Account
                                        System.out.print("Enter account ID : ");
                                        idStr = scanner.nextLine();
                                        id = Long.parseLong(idStr);
                                        System.out.print("Enter new account name: ");
                                        accountName = scanner.nextLine();
                                        System.out.print("Enter new account type: ");
                                        accountType = scanner.nextLine();
                                        System.out.print("Enter new account number: ");
                                        accountNumber = scanner.nextLine();
                                        System.out.print("Enter new IBAN: ");
                                        iban = scanner.nextLine();
                                        System.out.print("Enter new opening date (yyyy-mm-dd): ");
                                        openingDateStr = scanner.nextLine();
                                        openingDate = LocalDate.parse(openingDateStr);
                                        System.out.print("Enter new balance: ");
                                        balanceStr = scanner.nextLine();
                                        balance = Double.parseDouble(balanceStr);

                                        String result = accountService.updateAccount(id, accountName, accountType, accountNumber, iban, openingDate, balance);
                                        System.out.println(result);
                                        break;

                                    case 5:
                                        // Delete Account
                                        System.out.print("Enter account ID: ");
                                        idStr = scanner.nextLine();
                                        id = Long.parseLong(idStr);
                                        result = accountService.deleteAccount(id);
                                        System.out.println(result);
                                        break;

                                    case 6:
                                        // Confirm Before Deleting Account
                                        System.out.print("Enter account ID: ");
                                        idStr = scanner.nextLine();
                                        id = Long.parseLong(idStr);
                                        result = accountService.confirmBeforeDeletingAccount(id);
                                        System.out.println(result);
                                        break;

                                    case 7:
                                        // Money Transfer
                                        System.out.print("Enter sender account number: ");
                                        String senderAccount = scanner.nextLine();
                                        System.out.print("Enter receiver account number: ");
                                        String receiverAccount = scanner.nextLine();
                                        System.out.print("Enter transfer amount: ");
                                        String transferAmountStr = scanner.nextLine();
                                        double transferAmount = Double.parseDouble(transferAmountStr);
                                        System.out.print("Enter transfer type: ");
                                        String transferType = scanner.nextLine();
                                        System.out.print("Enter description: ");
                                        String description = scanner.nextLine();

                                        result = accountService.moneyTransfer(senderAccount, receiverAccount, transferAmount, transferType, description);
                                        System.out.println(result);
                                        break;
                                    case 8:
                                        // Display Transaction History
                                        System.out.print("Enter account number: ");
                                        accountNumber = scanner.nextLine();
                                        Account acc = accountService.findAccountById(accountNumber);
                                        if (acc != null) {
                                            System.out.println(accountService.displayTransactionHistory(acc));
                                        } else {
                                            System.out.println("Account not found!");
                                        }
                                        break;

                                    case 9:
                                        // Manage Balance
                                        System.out.print("Enter account number: ");
                                        accountNumber = scanner.nextLine();
                                        System.out.print("Enter amount to deposit/withdraw: ");
                                        String amountStr = scanner.nextLine();
                                        Double amount = Double.parseDouble(amountStr);

                                        Double newBalance = accountService.manageBalance(accountNumber, amount);
                                        System.out.println("New balance: " + newBalance);
                                        break;

                                    case 10:
                                        // Check Loan Eligibility
                                        System.out.print("Enter user ID: ");
                                        String userIdStr = scanner.nextLine();
                                        Long userId = Long.parseLong(userIdStr);
                                        Account userAccount = accountService.getAccountById(userId);
                                        if (userAccount != null) {
                                            System.out.println(accountService.checkLoanEligibility(user, userAccount));
                                        } else {
                                            System.out.println("Account not found!");
                                        }
                                        break;

                                    case 11:
                                        // Display Loan Application Status
                                        System.out.print("Enter user ID: ");
                                        userIdStr = scanner.nextLine();
                                        userId = Long.parseLong(userIdStr);
                                        System.out.print("Enter credit score: ");
                                        String creditScoreStr = scanner.nextLine();
                                        int creditScore = Integer.parseInt(creditScoreStr);
                                        System.out.print("Enter balance: ");
                                        String balanceIntStr = scanner.nextLine();
                                        int balanceInt = Integer.parseInt(balanceIntStr);
                                        System.out.print("Enter account history (months): ");
                                        String accountHistoryStr = scanner.nextLine();
                                        int accountHistory = Integer.parseInt(accountHistoryStr);

                                        String loanStatus = accountService.displayLoanApplicationStatus(userId, creditScore, balanceInt, accountHistory);
                                        System.out.println(loanStatus);
                                        break;

                                    case 12:
                                        // Back
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            } catch (Exception e) {
                                System.out.println("An error occurred: " + e.getMessage());
                            }
                        }

                    case 2:
                        // User Management
                        while (true) {
                            System.out.println("User Management System");
                            System.out.println("1. Create User");
                            System.out.println("2. Read All Users");
                            System.out.println("3. Read User By ID");
                            System.out.println("4. Update User By ID");
                            System.out.println("5. Delete User By ID");
                            System.out.println("6. Back");

                            System.out.print("Enter your choice: ");
                            String userChoiceStr = scanner.nextLine();
                            int userChoice;
                            try {
                                userChoice = Integer.parseInt(userChoiceStr);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid choice. Please enter a number.");
                                continue;
                            }

                            try {
                                switch (userChoice) {
                                    case 1:
                                        // Create User
                                        System.out.print("Enter user ID: ");
                                        String idStrr = scanner.nextLine();
                                        user.setId(Long.parseLong(idStrr));
                                        System.out.print("Enter full name: ");
                                        user.setFullName(scanner.nextLine());
                                        System.out.print("Enter email: ");
                                        user.setEmail(scanner.nextLine());
                                        System.out.print("Enter address: ");
                                        user.setAdress(scanner.nextLine());
                                        System.out.print("Enter password: ");
                                        user.setPassword(scanner.nextLine());
                                        System.out.print("Enter identity number: ");
                                        user.setIdentityNumber(scanner.nextLine());

                                        userService.createUserFromInput(user);
                                        break;

                                    case 2:
                                        // Read All Users
                                        userService.readAllUsers();
                                        break;

                                    case 3:
                                        // Read User By ID
                                        System.out.print("Enter user ID: ");
                                        String idStr = scanner.nextLine();
                                        Long userId = Long.parseLong(idStr);
                                        userService.readUserById(userId);
                                        break;

                                    case 4:
                                        // Update User By ID
                                        System.out.print("Enter user ID: ");
                                        String idStr2 = scanner.nextLine();
                                        userId = Long.parseLong(idStr2);
                                        userService.updateUserById(userId);
                                        break;

                                    case 5:
                                        // Delete User By ID
                                        System.out.print("Enter user ID: ");
                                        String idStr3 = scanner.nextLine();
                                        userId = Long.parseLong(idStr3);
                                        userService.deleteUserById(userId);
                                        break;

                                    case 6:
                                        // Back
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            } catch (Exception e) {
                                System.out.println("An error occurred: " + e.getMessage());
                            }
                        }

                    case 3:
                        // Exit
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}