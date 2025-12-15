/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author DELL
 */
public class HomeLoan extends Loan{

    public HomeLoan(int accountId, double amount, int years) {
        super(accountId, amount, years, "home");
    }
    
}
