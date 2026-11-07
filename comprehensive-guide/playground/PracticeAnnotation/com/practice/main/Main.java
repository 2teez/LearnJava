package com.practice.main;

import com.practice.employee.Employee;
import com.practice.manager.Manager;
import com.practice.practann.*;

public class Main {

    @Version
    public static void main(String[] args) {
        Employee ken = new Manager();
        ken.setSalary(200);
        main("Another static main function");
    }

    @Version(major = 1)
    public static void main(String args) {
        System.out.println(args);
        var ken = new Employee();
        ken.setSalary(200);
    }
}
