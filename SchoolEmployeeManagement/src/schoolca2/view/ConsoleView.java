/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.view;

import schoolca2.model.Employee;
import java.util.List;
/**
 *
 * @author Jeremiah
 */
public class ConsoleView {

    // Display all employee records
    public void displayEmployees(List<Employee> employees) {

        System.out.println("\n=================================");
        System.out.println(" SCHOOL EMPLOYEE MANAGEMENT");
        System.out.println("=================================");

        System.out.println("Total Employees: " + employees.size());

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("=================================");
    }

    // Display a message to the user
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
