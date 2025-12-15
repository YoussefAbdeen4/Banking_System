/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author DELL
 */
public class CarLoan extends Loan {

    public CarLoan(int accountId, double amount, int years) {
        super(accountId, amount, years, "car");
    }
    
}
