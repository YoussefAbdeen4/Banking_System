/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.*;
/**
 *
 * @author DELL
 */
public class LoanFactory {

    public static Loan createLoan(String type,int accountId,double amount,int years) {
        return switch (type.toLowerCase()) {
            case "home" -> new HomeLoan(accountId, amount, years);
            case "personal" -> new PersonalLoan(accountId, amount, years);
            case "car" -> new CarLoan(accountId, amount, years);
            default -> throw new IllegalArgumentException("Invalid loan type");
        };
    }
}

