package org.example.user;

import org.example.account.Account;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<User> userLists;

    public UserService(){
        this.userLists = new ArrayList<>();
    }

    public String inputValidationOnAccountCreation(User user) {

        if(user.getFullName() == null || user.getFullName().trim().isEmpty()){
            return "Please enter your real name";
        }
        if(user.getPassword() == null || user.getPassword().trim().isEmpty()){
            return "Please enter your password";
        }
        if (user.getIdentityNumber() == null || user.getIdentityNumber().trim().isEmpty()){
            return "Please enter your identity number";
        }
        return "Account successfully created.";
    }

    public User createUserFromInput(User user) {

        String validationMessage = inputValidationOnAccountCreation(user);
        System.out.println(validationMessage);

        if (validationMessage.equals("Account successfully created.")) {
            userLists.add(user);
        }

        return user;
    }

    public void readAllUsers() {
        if (userLists.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (User user : userLists) {
                System.out.println(user);
            }
        }
    }

    public User readUserById(Long id) {
        for (User user : userLists) {
            if (user.getId().equals(id)) {
                System.out.println(user);
                return user;
            }
        }
        System.out.println("User not found.");
        return null;
    }

    public void updateUserById(Long id) {
        User user = readUserById(id);
        if (user == null) {
            System.out.println("No users found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Update full name (current: " + user.getFullName() + "): ");
        String fullName = scanner.nextLine();
        user.setFullName(fullName);

        System.out.println("Update email (current: " + user.getEmail() + "): ");
        String email = scanner.nextLine();
        user.setEmail(email);

        System.out.println("Update address (current: " + user.getAdress() + "): ");
        String address = scanner.nextLine();
        user.setAdress(address);

        System.out.println("User updated successfully.");
    }

    public void deleteUserById(Long id) {
        User user = readUserById(id);
        if (user != null) {
            userLists.remove(user);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

}
