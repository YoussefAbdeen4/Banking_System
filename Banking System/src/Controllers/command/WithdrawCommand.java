/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.command.Command;

/**
 *
 * @author DELL
 */
public class WithdrawCommand implements Command {

    private int accountId;
    private double amount;

    public WithdrawCommand(int accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    public void execute() {
        TransactionManager.getInstance().executeWithdrawal(accountId, amount);
    }
}