/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.QueryBuilder;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Customer {
    private int id;
    private String name;
    private String ssn;
    private String email;
    private String phone;
    private int age;
    private String address;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    private Date createdAt;
    public Customer() {
    }

    public Customer(String name, String ssn, String email, String phone, int age, String address, String gender) {
        
        this.name = name;
        this.ssn = ssn;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void create() {
        String columns = "name, ssn, email, phone, age, address, gender";
        String data = "'" + name + "', " +
            "'" + ssn + "', " +
            "'" + email + "', " +
            "'" + phone + "', " +
            age + ", " +
            "'" + address + "', " +
            "'" + gender + "'";

        new QueryBuilder()
            .table("customers")
            .insert(columns, data)
            .execute();
    }
    
}
