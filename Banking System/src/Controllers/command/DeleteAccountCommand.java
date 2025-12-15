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
public class DeleteAccountCommand implements Command {

    private int accountId;

    public DeleteAccountCommand(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public void execute() {
        TransactionManager.getInstance().deleteAccount(accountId);
    }
}