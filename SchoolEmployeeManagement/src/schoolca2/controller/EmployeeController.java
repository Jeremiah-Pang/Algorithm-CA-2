/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.controller;

import schoolca2.model.Employee;
import schoolca2.model.EmployeeRepository;
import schoolca2.view.ConsoleView;
import schoolca2.model.EmployeeAlgorithms;
import schoolca2.model.EmployeeBinaryTree;
import schoolca2.MenuOption;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Jeremiah
 */
public class EmployeeController {
    
    private EmployeeRepository repository;
    private ConsoleView view;
    private EmployeeAlgorithms algorithms;
    
    // Create the Model and View objects
    public EmployeeController() {
        repository = new EmployeeRepository();
        view = new ConsoleView();
        algorithms = new EmployeeAlgorithms();
    }
    
    
    // Start the employee management system
    public void start() {

        try {

            String filename = "data/Applicants_Form.txt";

            view.displayMessage("Loading employee records...");

            // Read employee information from the file
            List<Employee> employees =
                    repository.loadEmployees(filename);

            view.displayMessage(
                    "File read successfully! Total employees: "
                    + employees.size()
            );

            boolean running = true;

            while (running) {

                view.displayMenu();

                MenuOption option = view.getMenuOption();

                if (option == null) {
                    continue;
                }

                switch (option) {

                    case SORT:

                        List<Employee> sortedEmployees =
                                algorithms.mergeSort(employees);

            // Display only the first 20 employees
            view.displayTop20Employees(sortedEmployees);

                    break;

            case SEARCH:
                List<Employee> searchList =
                        algorithms.mergeSort(employees);

                String searchName =
                        view.getEmployeeNameInput();

                Employee foundEmployee =
                        algorithms.binarySearch(
                            searchList, searchName
                                );

            // Display employee details
             view.displaySearchResult(foundEmployee);
                        break;

                    case ADD_RECORDS:
                        addNewEmployee(employees);
                        break;

                    case CREATE_BINARY_TREE:
                        EmployeeBinaryTree tree =
                                new EmployeeBinaryTree();

            // Insert all employee records
                for (Employee employee : employees) {
                        tree.insert(employee);
                        }

            // Get level-order traversal
                List<Employee> hierarchy =
                        tree.levelOrderTraversal();

            // Display employee hierarchy
                view.displayEmployeeHierarchy(
                        hierarchy,
                        tree.getHeight(),
                        tree.getNodeCount()
                        );
                break;

                case EXIT:
                    view.displayMessage(
                        "Thank you for using the system!"
                        );
                        running = false;
                        break;
                }
            }

        } catch (IOException e) {

            view.displayMessage(
                    "Error reading file: " + e.getMessage()
            );

        } catch (NumberFormatException e) {

            view.displayMessage(
                    "Invalid salary format in the file."
            );
        }
    }

    
    
    // Add a new employee
    private void addNewEmployee(List<Employee> employees) {

        System.out.println("\n=================================");
        System.out.println(" ADD NEW SCHOOL EMPLOYEE");
        System.out.println("=================================");

        // Get employee name
        String fullName = view.getNewEmployeeName();

        while (fullName.isEmpty()) {
            view.displayMessage("Name cannot be empty!");
            fullName = view.getNewEmployeeName();
        }

        String[] nameParts = fullName.split("\\s+", 2);

        String firstName = nameParts[0];
        String lastName = nameParts.length > 1
                ? nameParts[1] : "";

        // Get valid Manager Type
        String managerType = view.getManagerTypeInput();

        // Get existing departments
        Set<String> departmentSet = new TreeSet<>();

        for (Employee employee : employees) {
            departmentSet.add(employee.getDepartment());
        }

        List<String> departments =
                new ArrayList<>(departmentSet);

        // Get valid Department
        String department =
                view.getDepartmentInput(departments);

        // Create new employee
        Employee newEmployee = new Employee(
                firstName,
                lastName,
                "Not specified",
                "Not provided",
                0.0,
                department,
                "Not specified",
                "Not specified",
                "School",
                managerType
        );

        // Add employee to existing list
        employees.add(newEmployee);

        // Display newly added record
        view.displayNewEmployee(newEmployee);

        System.out.println("Total Employees: " + employees.size());
    }

}
