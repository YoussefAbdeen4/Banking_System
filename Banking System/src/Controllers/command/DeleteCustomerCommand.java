/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.TransactionManagerProxy;

/**
 *
 * @author DELL
 */
public class DeleteCustomerCommand implements Command {

    private int customerId;
    private final TransactionManagerProxy manager;

    public DeleteCustomerCommand(int customerId) {
        this.customerId = customerId;
        this.manager = new TransactionManagerProxy();
    }

    @Override
    public void execute() {
        manager.deleteCustomer(customerId);
    }
}
