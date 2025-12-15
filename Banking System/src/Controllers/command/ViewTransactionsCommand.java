/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.command.Command;
import Models.Transaction;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ViewTransactionsCommand implements Command {

    private List<Transaction> result;

    @Override
    public void execute() {
        result = TransactionManager.getInstance().viewTransactions();
    }

    public List<Transaction> getResult() {
        return result;
    }
}