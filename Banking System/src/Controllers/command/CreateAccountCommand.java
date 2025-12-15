/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.command.Command;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class CreateAccountCommand implements Command {

    private String ssn, type;
    private double balance;

    public CreateAccountCommand(String ssn, double balance, String type) {
        this.ssn = ssn;
        this.balance = balance;
        this.type = type;
    }

    @Override
    public void execute() {
        try {
            TransactionManager.getInstance().createAccount(ssn, balance, type);
        } catch (CloneNotSupportedException ex) {
           JOptionPane.showMessageDialog(
            null,
            "Cannot load data",
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
        }
        
    }
}
