/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.command.Command;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class ViewAccountsCommand implements Command {

    private List<Map<String, Object>> result;

    @Override
    public void execute() {
        result = TransactionManager.getInstance().viewAccounts();
    }

    public List<Map<String, Object>> getResult() {
        return result;
    }
}