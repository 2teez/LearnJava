package com.practice.manager;

import com.practice.employee.Employee;

public class Manager extends Employee {

    @Override
    public void setSalary(double salary) {
        System.out.println("Manager.setSalary(): " + salary);
    }
}
