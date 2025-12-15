/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.QueryBuilder;
import java.util.Date;

/**
 *
 * @author DELL
 */

public class Loan {
    private int id;
    private int accountId;
    private double amount;
    private int years;
    private String type;
    private Date createdAt;

    public Loan() {}
    public Loan(int accountId, double amount, int years, String type) {
        this.accountId = accountId;
        this.amount = amount;
        this.years = years;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public int getYears() { return years; }
    public void setYears(int years) { this.years = years; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public void create() {
        String columns = "account_id, amount, years, type";
        String data = getAccountId() + ", " + getAmount() + ", " + getYears() + ", '" + getType() + "'";

        new QueryBuilder()
                .table("loans")
                .insert(columns, data)
                .execute();
    }

}

