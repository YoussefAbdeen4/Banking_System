/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.TransactionManagerProxy;
import Controllers.command.Command;

/**
 *
 * @author DELL
 */
public class CreateLoanCommand implements Command {

    private int accountId, years;
    private double amount;
    private String type;
    private final TransactionManagerProxy manager;

    public CreateLoanCommand(int accountId, double amount, int years, String type) {
        this.accountId = accountId;
        this.amount = amount;
        this.years = years;
        this.type = type;
        this.manager = new TransactionManagerProxy();
    }

    @Override
    public void execute() {
        manager.createLoan(accountId, amount, years, type);
    }
}