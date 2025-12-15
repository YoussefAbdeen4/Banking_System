/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.state.ActiveState;
import Models.*;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
public class AccountFactory {

    private static final Account SAVING_ACCOUNT =new SavingAccount(0, 0.0,new ActiveState(), "savings") ;

    private static final Account CHECKING_ACCOUNT =new CheckingAccount(0, 0.0,new ActiveState(), "checking") ;
           
    private static final Account LOAN_ACCOUNT = new LoanAccount(0, 0.0,new ActiveState(), "loan") ;

    public static Account createAccount(String type, int customerId, double balance) throws CloneNotSupportedException {

        Account account;
        switch (type.toLowerCase().trim()) {
            case "saving" -> account = SAVING_ACCOUNT.clone();
            case "checking" -> account = CHECKING_ACCOUNT.clone();
            case "loan" -> account = LOAN_ACCOUNT.clone();
            default -> throw new IllegalArgumentException("Invalid account type");
        }
        account.setCustomerId(customerId);
        account.setBalance(balance);
        return account;
    }

}

