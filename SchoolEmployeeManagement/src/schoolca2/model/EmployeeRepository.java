/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeremiah
 */

public class EmployeeRepository {

    public List<Employee> loadEmployees(String filename)
            throws IOException {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader =
                new BufferedReader(new FileReader(filename))) {

            String line;

            // Skip the first line (CSV header)
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length != 9) {
                    System.out.println("Invalid record: " + line);
                    continue;
                }

                Employee employee = new Employee(
                    data[0].trim(),
                    data[1].trim(),
                    data[2].trim(),
                    data[3].trim(),
                    Double.parseDouble(data[4].trim()),
                    data[5].trim(),
                    data[6].trim(),
                    data[7].trim(),
                    data[8].trim(),
                    "Employee"
                );

                employees.add(employee);
            }
        }

        return employees;
    }
}
