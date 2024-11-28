package application;

import entities.Employee;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Alex", "alex@test.com");
        Employee employee2 = new Employee("Alex", "alex@test.com");
        Employee employee3 = new Employee("Ana", "ana@test.com");

        System.out.println(employee1.equals(employee2)); // true
        System.out.println(employee1.equals(employee3)); // false
    }
}