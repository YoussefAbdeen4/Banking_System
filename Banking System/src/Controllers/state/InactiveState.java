/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.state;


import Controllers.state.ActiveState;
import Controllers.state.AccountState;
import Models.Account;
import Models.Loan;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class InactiveState implements AccountState {

    @Override
    public void deposit(Account account, double amount) {
        JOptionPane.showMessageDialog(null, "Account is closed", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void withdraw(Account account, double amount) {
        JOptionPane.showMessageDialog(null, "Account is closed", "Error", JOptionPane.ERROR_MESSAGE);

    }

    @Override
    public void takeLoan(Loan loan,Account account) {
        JOptionPane.showMessageDialog(null, "Account is closed", "Error", JOptionPane.ERROR_MESSAGE);
    }
    @Override
    public AccountState nextState() {
        return new ActiveState();
    }
}