/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.model;

/**
 *
 * @author Jeremiah
 */
public class Employee {
    
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;
    private String department;
    private String position;
    private String jobTitle;
    private String company;
    private String managerType;
    
    public Employee(String firstName, String lastName, String gender, String email, double salary, String department, String position, String jobTitle, String company, String managerType) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
        this.company = company;
        this.managerType = managerType;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getPosition() {
        return position;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
    
    public String getCompany(){
        return company;
    }
    
    public String getManagerType() {
        return managerType;
    }
    
    public void setManagerType(String managerType) {
    this.managerType = managerType;
}
    
    @Override
    public String toString(){
        return "Name: " + getFullName() +
                ""
                + "| Department: " + department
                + "| Position: " + position
                + "| Job Title: " + jobTitle;
    }
}
