/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.AccountFactory;
import Controllers.state.ActiveState;
import Controllers.state.InactiveState;
import Controllers.LoanFactory;
import Database.QueryBuilder;
import Models.Account;
import Models.Customer;
import Models.Loan;
import Models.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class TransactionManager {

    private static TransactionManager instance;

    private TransactionManager() {
    }

    public static TransactionManager getInstance() {
        if (instance == null) {
            synchronized (TransactionManager.class) {
                if (instance == null) {
                    instance = new TransactionManager();
                }
            }
        }
        return instance;
    }

    public void createCustomer(String name, String ssn, String email, String phone, int age, String address, String gender) {
        Customer customer = new Customer(name, ssn, email, phone, age, address, gender);
        customer.create();
    }

    public void createAccount(String ssn, double balance, String type) throws CloneNotSupportedException {

        List<Map<String, Object>> result = new QueryBuilder()
                .table("customers")
                .select("id")
                .where("ssn = '" + ssn + "'")
                .get();

        if (result.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Wrong SSN", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int customerId = (int) result.get(0).get("id");

        Account account = AccountFactory.createAccount(type, customerId, balance);
        account.create();
        JOptionPane.showMessageDialog(null,"Account created successfully!","Success", JOptionPane.INFORMATION_MESSAGE);

    }

    public void changeAccountStatus(int id) {
        Account account = getAccount(id);
        switch (account.getStatus().toUpperCase()) {
            case "ACTIVE" -> {
                account.setStatus(new ActiveState().nextState());
            }
            case "INACTIVE" -> {
                account.setStatus(new InactiveState().nextState());
            }
            default -> {
                System.out.println("Invalid status");
                return;
            }
        }

        new QueryBuilder()
                .table("accounts")
                .update("status = '" + account.getStatus() + "'")
                .where("id = " + id)
                .execute();
    }

    public void executeWithdrawal(int id, double amount) {
        Account account = getAccount(id);
        if (account == null) {
            JOptionPane.showMessageDialog(null, "Wrong Account number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        account.status().withdraw(account, amount);
        new QueryBuilder()
                .table("accounts")
                .update("balance = " + account.getBalance())
                .where("id = " + id)
                .execute();
        createTransaction(id,"Withdraw",amount);
        JOptionPane.showMessageDialog(null,"Operation done Successfuly","Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void executeDeposit(int id, double amount) {
        Account account = getAccount(id);
        if (account == null) {
            JOptionPane.showMessageDialog(null, "Wrong Account number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        account.status().deposit(account, amount);
        new QueryBuilder()
                .table("accounts")
                .update("balance = " + account.getBalance())
                .where("id = " + id)
                .execute();
        createTransaction(id,"Deposit",amount);
        JOptionPane.showMessageDialog(null,"Operation done Successfuly","Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // --- Loan Operations ---
    public void createLoan(int accountId, double amount, int years, String type) {
        Account account = getAccount(accountId);
        if(account == null){
             JOptionPane.showMessageDialog(null, "The account number invalid", "Error", JOptionPane.ERROR_MESSAGE);
             return;
       }
        if(account.getType().toLowerCase().equals("loan")){
            Loan loan = LoanFactory.createLoan(type, accountId, amount, years);
            account.status().takeLoan(loan,account);
            new QueryBuilder()
                .table("accounts")
                .update("balance = " + account.getBalance())
                .where("id = " + accountId)
                .execute();
            createTransaction(accountId,"Loan",amount);
            JOptionPane.showMessageDialog(null,"Operation done Successfuly","Success", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "The account type invalid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void createTransaction(int accountId, String type, double amount) {

    Transaction transaction = new Transaction( accountId, type, amount);
    transaction.create();
}


    private Account getAccount(int id) {
        List<Map<String, Object>> result = new QueryBuilder()
                .table("accounts")
                .select()
                .where("id = " + id)
                .get();

        if (result.isEmpty()) {
            System.out.println("Account not found");
            return null;
        }
        Map<String, Object> row = result.get(0);

        Account account = new Account();
        account.setCustomerId((int) row.get("customer_id"));
        account.setBalance(((Number) row.get("balance")).doubleValue());
        account.setType((String) row.get("Type"));
        String status = (String) row.get("status");
        if (status.equals("Active")) {
            account.setStatus(new ActiveState());
        } else {
            account.setStatus(new InactiveState());
        }
        return account;
    }
    public List<Map<String, Object>> viewAccounts() {

    return new QueryBuilder()
            .table("accounts a")
            .select(
                "c.name, c.ssn, a.id AS account_id, " +
                "a.*"
            )
            .join("customers c", "a.customer_id = c.id")
            .get();
}
    
    public List<Customer> viewCustomers() {

    List<Customer> customers = new ArrayList<>();

    List<Map<String, Object>> result = new QueryBuilder()
            .table("customers")
            .select()
            .get();

    for (Map<String, Object> row : result) {
        Customer c = new Customer();
        c.setId((int) row.get("id"));
        c.setName((String) row.get("name"));
        c.setSsn((String) row.get("ssn"));
        c.setEmail((String) row.get("email"));
        c.setPhone((String) row.get("phone"));
        c.setAge((int) row.get("age"));
        c.setAddress((String) row.get("address"));
        c.setGender(((String) row.get("Gender")));
        c.setCreatedAt((java.util.Date) row.get("created_at"));
        customers.add(c);
    }

    return customers;
}

    public List<Loan> viewLoans() {

    List<Loan> loans = new ArrayList<>();

    List<Map<String, Object>> result = new QueryBuilder()
            .table("loans")
            .select()
            .get();

    for (Map<String, Object> row : result) {

        Loan loan = LoanFactory.createLoan(
                (String) row.get("type"),
                (int) row.get("account_id"),
                ((Number) row.get("amount")).doubleValue(),
                (int) row.get("years")
        );

        loan.setId((int) row.get("id"));
        loan.setCreatedAt((java.util.Date) row.get("created_at"));

        loans.add(loan);
    }

    return loans;
}
public List<Transaction> viewTransactions() {

    List<Transaction> transactions = new ArrayList<>();

    List<Map<String, Object>> result = new QueryBuilder()
            .table("transactions")
            .select()
            .get();

    for (Map<String, Object> row : result) {

        Transaction t = new Transaction(
                (int) row.get("account_id"),
                (String) row.get("type"),
                ((Number) row.get("amount")).doubleValue()
        );

        t.setId((int) row.get("id"));
        t.setCreatedAt((java.util.Date) row.get("timestamp"));

        transactions.add(t);
    }

    return transactions;
}
public void deleteCustomer(int customerId) {
        new QueryBuilder()
                .table("customers")
                .delete()
                .where("id = " + customerId)
                .execute();
    }

    public void deleteAccount(int accountId) {
        new QueryBuilder()
                .table("accounts")
                .delete()
                .where("id = " + accountId)
                .execute();
    }
}