/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.state;

import Models.Account;
import Models.Loan;

/**
 *
 * @author DELL
 */
public interface AccountState {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    void takeLoan(Loan loan,Account account);
    AccountState nextState();
}

