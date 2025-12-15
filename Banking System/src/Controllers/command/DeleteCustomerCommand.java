/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;

/**
 *
 * @author DELL
 */
public class DeleteCustomerCommand implements Command {

    private int customerId;

    public DeleteCustomerCommand(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public void execute() {
        TransactionManager.getInstance().deleteCustomer(customerId);
    }
}
