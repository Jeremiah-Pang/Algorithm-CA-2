/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeremiah
 */
public class EmployeeAlgorithms {
    
    // Recursive Merge Sort
    public List<Employee> mergeSort(List<Employee> employees){
        
        if (employees.size() <= 1) {
            return employees;
        }
        
        int middle = employees.size() / 2;
        
        List<Employee> left = new ArrayList<>(
                employees.subList(0,middle));
        
        List<Employee> right = new ArrayList<>(
                employees.subList(middle, employees.size()));
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left, right);
    }
    
    // Merge two sorted lists
    private List<Employee> merge(
            List<Employee> left,
            List<Employee> right) {
        
        List<Employee> result = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while (i < left.size() && j < right.size()){
            
            String name1 = left.get(i).getFullName();
            String name2 = right.get(j).getFullName();
            
            if (name1.compareToIgnoreCase(name2) <= 0){
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        
        return result;
    }
}
