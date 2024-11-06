import java.util.Scanner;

// Taxable Interface
interface Taxable {
    double salesTax = 0.07; // 7% Sales Tax
    double incomeTax = 0.105; // 10.5% Income Tax

    double calcTax();
}

// Employee Class implementing Taxable
class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    // Implementing calcTax to calculate income tax on yearly salary
    @Override
    public double calcTax() {
        return salary * incomeTax;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }
}

// Product Class implementing Taxable
class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

//    git chek

    // Implementing calcTax to calculate sales tax on unit price
    @Override
    public double calcTax() {
        return price * salesTax;
    }

    @Override
    public String toString() {
        return "Product ID: " + pid + ", Price: " + price + ", Quantity: " + quantity;
    }
}

// DriverMain Class
public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Employee information
        System.out.println("Enter Employee Information:");
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double monthlySalary = scanner.nextDouble();

        //  calculating income tax
        Employee employee = new Employee(empId, name, monthlySalary * 12); // Converting to yearly salary
        System.out.println("\n" + employee);
        System.out.printf("Income Tax on Yearly Salary: %.2f\n", employee.calcTax());

        //  Product information
        System.out.println("\nEnter Product Information:");
        System.out.print("Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Unit Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        //  sales tax on unit price
        Product product = new Product(pid, price, quantity);
        System.out.println("\n" + product);
        System.out.printf("Sales Tax on Unit Price: %.2f\n", product.calcTax());

        scanner.close();
    }
}
