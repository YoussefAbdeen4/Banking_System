/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.command.Command;
import Models.Customer;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ViewCustomersCommand implements Command {

    private List<Customer> result;

    @Override
    public void execute() {
        result = TransactionManager.getInstance().viewCustomers();
    }

    public List<Customer> getResult() {
        return result;
    }
}