/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Request.validation;

/**
 *
 * @author DELL
 */
import java.util.regex.Pattern;

public class Validation {

    // ---------- Customer ----------
    public static boolean isValidName(String name) {
        return name != null &&Pattern.matches("^[A-Za-z ]{4,100}$", name);
    }

    public static boolean isValidSSN(String ssn) {
        return ssn != null && Pattern.matches("\\d{14}", ssn);
    }

    public static boolean isValidEmail(String email) {
        return email != null &&
               Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email);
    }

    public static boolean isValidPhone(String phone) {
        return phone != null &&
               Pattern.matches("^01[0-2,5][0-9]{8}$", phone);
    }

    public static boolean isValidAge(int age) {
        return age >= 18 && age <= 100;
    }

    public static boolean isValidAddress(String address) {
        return address != null && address.length() >= 3;
    }

    public static boolean isValidGender(String gender) {
        return gender != null &&
              (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"));
    }

    // ---------- Account ----------
    public static boolean isValidBalance(double balance) {
        return balance >= 0;
    }

    public static boolean isValidAccountType(String type) {
        return type != null &&
              (type.trim().equalsIgnoreCase("saving")
            || type.trim().equalsIgnoreCase("checking")
            || type.trim().equalsIgnoreCase("loan"));
    }

    // ---------- Transactions ----------
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    // ---------- Loan ----------
    public static boolean isValidLoanYears(int years) {
        return years >= 1 && years <= 30;
    }

    public static boolean isValidLoanType(String type) {
        return type != null &&
              (type.equalsIgnoreCase("home")
            || type.equalsIgnoreCase("personal")
            || type.equalsIgnoreCase("car"));
    }

    // ---------- IDs ----------
    public static boolean isValidId(int id) {
        return id > 0;
    }
}

