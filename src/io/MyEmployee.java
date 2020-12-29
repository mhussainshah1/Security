package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyEmployee {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var employees = new ArrayList<Employee>();
        employees.add(new Employee("Jane", "111111111", 20));
//        employees.add(new Employee("Enos", "222222222", 30));
        File dataFile = new File("src/io/employee.log");

        saveToFile(employees, dataFile);
        var employeesFromDisk = readFromFile(dataFile);
        System.out.println(employeesFromDisk);
    }

    private static void saveToFile(List<Employee> employees, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            for (Employee employee : employees)
                out.writeObject(employee);
        }
    }

    private static List<Employee> readFromFile(File dataFile) throws IOException, ClassNotFoundException {
        var employees = new ArrayList<Employee>();
        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(dataFile)))) {
            while (true) {
                var object = in.readObject();
                if (object instanceof Employee)
                    employees.add((Employee) object);
            }
        } catch (EOFException e) {
            // File end reached
//            e.printStackTrace();
        }
        return employees;
    }
}