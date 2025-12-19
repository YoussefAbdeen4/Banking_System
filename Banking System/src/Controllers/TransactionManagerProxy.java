/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Request.validation.Validation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TransactionManagerProxy implements ITransactionManager {

    private final TransactionManager manager
            = TransactionManager.getInstance();

    // ================= CUSTOMER =================
    @Override
    public void createCustomer(String name, String ssn, String email, String phone, int age, String address, String gender) {

        List<String> errors = new ArrayList<>();

        if (!Validation.isValidName(name)) {
            errors.add("• Invalid name");
        }

        if (!Validation.isValidSSN(ssn)) {
            errors.add("• SSN must be 14 digits");
        }

        if (!Validation.isValidEmail(email)) {
            errors.add("• Invalid email");
        }

        if (!Validation.isValidPhone(phone)) {
            errors.add("• Invalid phone number");
        }

        if (!Validation.isValidAge(age)) {
            errors.add("• Age must be between 18 and 100");
        }

        if (!Validation.isValidAddress(address)) {
            errors.add("• Address is too short");
        }

        if (!Validation.isValidGender(gender)) {
            errors.add("• Gender must be M or F");
        }

        if (!errors.isEmpty()) {
            showErrors(errors);
            return;
        }

        manager.createCustomer(name, ssn, email, phone, age, address, gender);
       JOptionPane.showMessageDialog(null,"Customer created successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // ================= ACCOUNT =================
    @Override
    public void createAccount(String ssn, double balance, String type)
            throws CloneNotSupportedException {

        List<String> errors = new ArrayList<>();

        if (!Validation.isValidSSN(ssn)) {
            errors.add("• Invalid SSN");
        }

        if (!Validation.isValidBalance(balance)) {
            errors.add("• Balance cannot be negative");
        }

        if (!Validation.isValidAccountType(type)) {
            errors.add("• Invalid account type");
        }

        if (!errors.isEmpty()) {
            showErrors(errors);
            return;
        }

        manager.createAccount(ssn, balance, type);
    }

    @Override
    public void changeAccountStatus(int id) {
        if (!Validation.isValidId(id)) {
            JOptionPane.showMessageDialog(null,
                    "Invalid account ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        manager.changeAccountStatus(id);
    }

    @Override
    public void executeWithdrawal(int id, double amount) {
 List<String> errors = new ArrayList<>();

        if (!Validation.isValidId(id)) {
            errors.add("• Invalid account ID");
        }

        if (!Validation.isValidAmount(amount)) {
            errors.add("• Amount must be greater than zero");
        }

        if (!errors.isEmpty()) {
            showErrors(errors);
            return;
        }
        
        manager.executeWithdrawal(id, amount);

    }

    @Override
    public void executeDeposit(int id, double amount) {
       List<String> errors = new ArrayList<>();

        if (!Validation.isValidId(id)) {
            errors.add("• Invalid account ID");
        }

        if (!Validation.isValidAmount(amount)) {
            errors.add("• Amount must be greater than zero");
        }

        if (!errors.isEmpty()) {
            showErrors(errors);
            return;
        }
        manager.executeDeposit(id, amount); 
       
    }

    // ================= DEPOSIT =================
    public void deposit(int accountId, double amount) {

       
    }

    // ================= WITHDRAW =================
    public void withdraw(int accountId, double amount) {

        
    }

    // ================= LOAN =================
    @Override
    public void createLoan(int accountId, double amount, int years, String type) {

        List<String> errors = new ArrayList<>();

        if (!Validation.isValidId(accountId)) {
            errors.add("• Invalid account ID");
        }

        if (!Validation.isValidAmount(amount)) {
            errors.add("• Invalid loan amount");
        }

        if (!Validation.isValidLoanYears(years)) {
            errors.add("• Loan years must be between 1 and 30");
        }

        if (!Validation.isValidLoanType(type)) {
            errors.add("• Invalid loan type");
        }

        if (!errors.isEmpty()) {
            showErrors(errors);
            return;
        }

        manager.createLoan(accountId, amount, years, type);
    }

    // ================= DELETE =================
    @Override
    public void deleteCustomer(int customerId) {

        if (!Validation.isValidId(customerId)) {
            JOptionPane.showMessageDialog(null,
                    "Invalid customer ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        manager.deleteCustomer(customerId);
    }

    @Override
    public void deleteAccount(int accountId) {

        if (!Validation.isValidId(accountId)) {
            JOptionPane.showMessageDialog(null,
                    "Invalid account ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        manager.deleteAccount(accountId);
    }

    // ================= VIEWS =================
    // ================= HELPER =================
    private void showErrors(List<String> errors) {
        StringBuilder msg = new StringBuilder("Validation Errors:\n\n");
        for (String e : errors) {
            msg.append(e).append("\n");
        }
        JOptionPane.showMessageDialog(null, msg.toString(),
                "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

}
