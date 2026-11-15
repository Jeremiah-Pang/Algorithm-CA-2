/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.view;

import schoolca2.model.Employee;
import java.util.List;
import java.util.Scanner;

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
    
    
    // Display the first 20 sorted employees
    public void displayTop20Employees(List<Employee> employees) {

        System.out.println("\n=================================");
        System.out.println(" TOP 20 SCHOOL EMPLOYEES");
        System.out.println("=================================");

        int limit = Math.min(20, employees.size());

        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }

        System.out.println("=================================");
    }
    
    private Scanner scanner = new Scanner(System.in);

    // Ask user for employee name
    public String getEmployeeNameInput() {

        System.out.print("\nEnter employee full name: ");

        return scanner.nextLine().trim();
    }

    // Display search result
    public void displaySearchResult(Employee employee) {

        if (employee == null) {
            System.out.println("\nEmployee not found!");
            return;
        }

        System.out.println("\n=================================");
        System.out.println(" EMPLOYEE SEARCH RESULT");
        System.out.println("=================================");

        System.out.println("Name: " + employee.getFullName());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Job Title: " + employee.getJobTitle());

        System.out.println("=================================");
    }


}
