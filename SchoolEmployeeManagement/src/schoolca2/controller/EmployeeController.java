/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.controller;

import schoolca2.model.Employee;
import schoolca2.model.EmployeeRepository;
import schoolca2.view.ConsoleView;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Jeremiah
 */
public class EmployeeController {
    
    private EmployeeRepository repository;
    private ConsoleView view;
    
    // Create the Model and View objects
    public EmployeeController() {
        repository = new EmployeeRepository();
        view = new ConsoleView();
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
            
            // Display all employee records
            view.displayEmployees(employees);
            
        }catch (IOException e){
            
            view.displayMessage("Error reading file: " + e.getMessage());
 
        } catch (NumberFormatException e) {
            
            view.displayMessage("Invalid salary format in the file");
        }
    }
}
