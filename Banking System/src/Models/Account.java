/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Controllers.state.AccountState;
import Controllers.state.ActiveState;
import Database.QueryBuilder;

/**
 *
 * @author DELL
 */
public class Account implements Cloneable{
    private int Id;
    private int customerId;
    private double balance;
    private AccountState status;
    private String type;

    public Account() {
    }

    public Account(int customerId, double balance, AccountState status, String type) {
        this.customerId = customerId;
        this.balance = balance;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public AccountState status() {
        return this.status;
    }
    
    public String getStatus() {
        if (status instanceof ActiveState) {
            return "Active";
        }
        return "Inactive";
    }

    public void setStatus(AccountState status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
@Override
    public Account clone() throws CloneNotSupportedException {
        try {
            return (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
    public void create() {
        String columns = "customer_id, balance, status, type";
        String data = customerId + ", "+ balance + ", '"+getStatus() + "', '"+ type + "'";

        new QueryBuilder()
                .table("accounts")
                .insert(columns, data)
                .execute();
    }

    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful");
        
    }

    public void withdraw(Account account, double amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance");
            return;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdraw successful");
    }
    @Override
    public String toString() {
        return "Account{" + "Id=" + Id + ", customerId=" + customerId + ", balance=" + balance + ", status=" + status + ", type=" + type + '}';
    }

   
    
}
