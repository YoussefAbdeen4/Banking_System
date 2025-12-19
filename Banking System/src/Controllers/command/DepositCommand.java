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
public class DepositCommand implements Command {

    private int accountId;
    private double amount;
    private final TransactionManagerProxy manager;

    public DepositCommand(int accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
        this.manager = new TransactionManagerProxy();
    }

    @Override
    public void execute() {
        manager.executeDeposit(accountId, amount);
    }
}

