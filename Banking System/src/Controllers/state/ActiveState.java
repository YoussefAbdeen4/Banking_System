/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.state;


import Controllers.state.AccountState;
import Models.Account;
import Models.Loan;

/**
 *
 * @author DELL
 */
public class ActiveState implements AccountState {

    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful");
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance");
            return;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdraw successful");
    }

    @Override
    public void takeLoan(Loan loan,Account account) {
        loan.create();
        deposit(account,loan.getAmount());
    }
    @Override
    public AccountState nextState() {
        return new InactiveState();
    }
}

