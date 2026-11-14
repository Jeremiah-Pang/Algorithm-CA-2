/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.controller;

import schoolca2.model.Employee;
import schoolca2.model.EmployeeRepository;
import schoolca2.view.ConsoleView;
import schoolca2.model.EmployeeAlgorithms;

import java.io.IOException;
import java.util.List;

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
            
            view.displayMessage("File read successfully!");
            
            // Sort employee records alphabetically
                List<Employee> sortedEmployees =
                        algorithms.mergeSort(employees);

            // Display only the first 20 employees
                view.displayTop20Employees(sortedEmployees);
            
        }catch (IOException e){
            
            view.displayMessage("Error reading file: " + e.getMessage());
 
        } catch (NumberFormatException e) {
            
            view.displayMessage("Invalid salary format in the file");
        }
    }
}
