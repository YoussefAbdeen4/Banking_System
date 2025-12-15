/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.command.Command;
import Models.Loan;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ViewLoansCommand implements Command {

    private List<Loan> result;

    @Override
    public void execute() {
        result = TransactionManager.getInstance().viewLoans();
    }

    public List<Loan> getResult() {
        return result;
    }
}
