import java.util.ArrayList;

public class Payroll {
    // Method to calculate and display salary for an employee
    public static void displaySalaryDetails(Employee employee) {
        double netSalary = employee.calculateNetSalary();
        System.out.println("Salary Details for Employee ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Basic Salary: " + employee.getBasicSalary());
        System.out.println("Allowance: " + employee.getAllowance());
        System.out.println("Deduction: " + employee.getDeduction());
        System.out.println("Net Salary: " + netSalary);
        System.out.println("-----------------------------");
    }

    // Method to display salaries for all employees
    public static void displayAllSalaries(ArrayList<Employee> employees) {
        for (Employee emp : employees) {
            displaySalaryDetails(emp);
        }
    }
}
