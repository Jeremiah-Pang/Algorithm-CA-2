/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.view;

import schoolca2.model.Employee;
import java.util.List;
import java.util.Scanner;
import schoolca2.MenuOption;

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
    
    
    // Get new employee name
    public String getNewEmployeeName() {

        System.out.print("\nEnter employee full name: ");

        return scanner.nextLine().trim();
    }

    // Select a valid Manager Type
    public String getManagerTypeInput() {

        String[] managerTypes = {
            "Senior Manager",
            "Manager",
            "Team Lead",
            "Employee"
        };

        while (true) {

            System.out.println("\nSelect Manager Type:");

            for (int i = 0; i < managerTypes.length; i++) {
                System.out.println(
                    (i + 1) + ". " + managerTypes[i]
                );
            }

            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            try {
                int number = Integer.parseInt(choice);

                if (number >= 1 && number <= managerTypes.length) {
                    return managerTypes[number - 1];
                }

            } catch (NumberFormatException e) {
                // Invalid number
            }

            System.out.println("Invalid choice! Please try again.");
        }
    }

    // Select an existing Department
    public String getDepartmentInput(List<String> departments) {

        while (true) {

            System.out.println("\nSelect Department:");

            for (int i = 0; i < departments.size(); i++) {
                System.out.println(
                    (i + 1) + ". " + departments.get(i)
                );
            }

            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            try {
                int number = Integer.parseInt(choice);

                if (number >= 1 && number <= departments.size()) {
                    return departments.get(number - 1);
                }

            } catch (NumberFormatException e) {
                // Invalid number
            }

            System.out.println("Invalid department! Please try again.");
        }
    }

    // Display newly added employee
    public void displayNewEmployee(Employee employee) {

        System.out.println("\nEmployee added successfully!");

        System.out.println("Name: " + employee.getFullName());
        System.out.println("Manager Type: " + employee.getManagerType());
        System.out.println("Department: " + employee.getDepartment());
    }
    
    
    // Display employee hierarchy
    public void displayEmployeeHierarchy(
            List<Employee> employees,
            int height,
            int nodeCount) {

        System.out.println("\n=================================");
        System.out.println(" SCHOOL EMPLOYEE BINARY TREE");
        System.out.println("=================================");

        for (int i = 0; i < employees.size(); i++) {

            Employee employee = employees.get(i);

            System.out.println(
                (i + 1) + ". " +
                employee.getFullName() +
                " | Manager Type: " +
                employee.getManagerType() +
                " | Department: " +
                employee.getDepartment()
            );
        }

        System.out.println("---------------------------------");
        System.out.println("Tree Height: " + height);
        System.out.println("Total Nodes: " + nodeCount);
        System.out.println("=================================");
    }
    
    
    // Display the main menu
    public void displayMenu() {

        System.out.println("\n=================================");
        System.out.println(" SCHOOL EMPLOYEE MANAGEMENT");
        System.out.println("=================================");

        for (MenuOption option : MenuOption.values()) {

            System.out.println(
                option.getNumber() + ". " +
                option.name().replace('_', ' ')
            );
        }

        System.out.println("=================================");
        System.out.print("Please select an option: ");
    }

    // Get menu selection from user
    public MenuOption getMenuOption() {

        String input = scanner.nextLine().trim();

        try {

            int choice = Integer.parseInt(input);

            MenuOption option =
                    MenuOption.fromNumber(choice);

            if (option != null) {
                return option;
            }

        } catch (NumberFormatException e) {
            // Invalid input
        }

        System.out.println("Invalid option! Please enter 1-5.");

        return null;
    }

}
