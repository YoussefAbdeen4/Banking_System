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
public class Transaction {
    private int id;
    private int accountId;
    private String type;
    private double amount;
    private Date createdAt;

    public Transaction() {
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

    public Transaction(int accountId, String type, double amount) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void create() {
        String columns = "account_id, type, amount";
        String data = accountId + ", '" + type + "', " + amount;

        new QueryBuilder()
                .table("transactions")
                .insert(columns, data)
                .execute();
    }
}
