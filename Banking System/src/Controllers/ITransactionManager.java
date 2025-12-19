/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers;

public interface ITransactionManager {

    void createCustomer(String name, String ssn, String email, String phone, int age, String address, String gender);

    void createAccount(String ssn, double balance, String type) throws CloneNotSupportedException;

    void changeAccountStatus(int id);

    void executeWithdrawal(int id, double amount);

    void executeDeposit(int id, double amount);

    void createLoan(int accountId, double amount, int years, String type);

    void deleteCustomer(int customerId);

    void deleteAccount(int accountId);
}
