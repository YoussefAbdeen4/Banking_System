/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Controllers.state.AccountState;

/**
 *
 * @author DELL
 */
public class SavingAccount extends Account {

    public SavingAccount(int customerId, double balance, AccountState status, String type) {
        super(customerId, balance, status, type);
    }
    
}
