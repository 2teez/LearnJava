package com.practice.employeedemo;

class EmployeeDemo {

    public static void main(String[] args) {
        try {
            var employee = new Employee("John Doe", 23, -3400);
            System.out.println(employee);
        } catch (PersonException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

interface IPerson {
    String getName();
    int getAge();
}

class PersonException extends Exception {

    String message;

    public PersonException(String message) {
        super(message);
    }
}

class Employee implements IPerson {

    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary)
        throws PersonException {
        setAge(age);
        setName(name);
        setSalary(salary);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) throws PersonException {
        if (name == null || name.isEmpty()) {
            throw new PersonException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setAge(int age) throws PersonException {
        if (age <= 0) {
            throw new PersonException("Age must be positive");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return (
            "Employee [name=" +
            name +
            ", age=" +
            age +
            ", salary=" +
            salary +
            "]"
        );
    }
}
