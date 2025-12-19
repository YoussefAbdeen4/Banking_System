/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.state;


import Controllers.TransactionManager;
import Controllers.state.AccountState;
import Database.QueryBuilder;
import Models.Account;
import Models.Loan;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ActiveState implements AccountState {

    @Override
    public void deposit(Account account, double amount) {
        account.deposit(account,amount);
        new QueryBuilder()
                .table("accounts")
                .update("balance = " + account.getBalance())
                .where("id = " +account.getId() )
                .execute();
        TransactionManager.getInstance().createTransaction(account.getId(),"Deposit",amount);
        JOptionPane.showMessageDialog(null,"Operation done Successfuly","Success", JOptionPane.INFORMATION_MESSAGE);
        
    }

    @Override
    public void withdraw(Account account, double amount) {
        account.withdraw(account, amount);
        new QueryBuilder()
                .table("accounts")
                .update("balance = " + account.getBalance())
                .where("id = " +account.getId() )
                .execute();
        TransactionManager.getInstance().createTransaction(account.getId(),"Deposit",amount);
        JOptionPane.showMessageDialog(null,"Operation done Successfuly","Success", JOptionPane.INFORMATION_MESSAGE);
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

