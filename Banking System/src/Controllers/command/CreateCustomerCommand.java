/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.command;

import Controllers.TransactionManager;
import Controllers.TransactionManagerProxy;
import Controllers.command.Command;

/**
 *
 * @author DELL
 */
public class CreateCustomerCommand implements Command {

    private String name, ssn, email, phone, address;
    private int age;
    private String gender;
    private final TransactionManagerProxy manager;

    public CreateCustomerCommand(String name, String ssn, String email,String phone, int age, String address, String gender) {

        this.name = name;
        this.ssn = ssn;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.manager = new TransactionManagerProxy();
    }

    @Override
    public void execute() {
        manager.createCustomer(name, ssn, email, phone, age, address, gender);
    }
}
