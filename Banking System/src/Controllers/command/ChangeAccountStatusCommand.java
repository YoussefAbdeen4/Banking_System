/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.command.Command;

/**
 *
 * @author DELL
 */
public class ChangeAccountStatusCommand implements Command {

    private int accountId;

    public ChangeAccountStatusCommand(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public void execute() {
        TransactionManager manager = TransactionManager.getInstance();
        manager.changeAccountStatus(accountId);
    }
}