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
public class ChangeAccountStatusCommand implements Command {

    private int accountId;
    private final TransactionManagerProxy manager;

    public ChangeAccountStatusCommand(int accountId) {
        this.accountId = accountId;
        this.manager = new TransactionManagerProxy();
    }

    @Override
    public void execute() {
        
        manager.changeAccountStatus(accountId);
    }
}