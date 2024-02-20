package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //BaseEmployee employee1 = Employee.create("Employee1", new int[]{2020,10,13},1000); // Exception by birthday
        //BaseEmployee employee2 = Employee.create("Employee2", new int[]{1994,10,13},0);    // Exception by salary
        //BaseEmployee employee3 = Employee.create("3", new int[]{1993,10,13},3000);         // Exception by name

        Employee[] employees = new Employee[]{
                Employee.create("Employee4", new int[]{1992,10,1},4000),
                Employee.create("Employee5", new int[]{1995,11,11},6000),
                Employee.create("Employee5", new int[]{1994,12,23},7000),
                Employee.create("Employee5", new int[]{1993,2,3},8000),
                Boss.create("Boss1",new int[]{1992,10,1},10000,new Employee[2]),
                Boss.create("Boss2",new int[]{1992,10,1},11000,new Employee[2]),
                Boss.create("Boss3",new int[]{1992,10,1},12000,new Employee[2])
        };


        for (Employee employee : employees) {
            Boss.upSalary(employee, 1.2f);
            System.out.println(employee.getSalary());
        }
    }

}
