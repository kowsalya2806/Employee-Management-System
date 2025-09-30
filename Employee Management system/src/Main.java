import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Department> departments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String currentUser = null;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System");
        while (currentUser == null) {
            currentUser = Authentication.authenticate(scanner);
            if (currentUser == null) {
                System.out.println("Invalid credentials. Try again.");
            }
        }
        System.out.println("Login successful as " + currentUser);

        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    addDepartment();
                    break;
                case 6:
                    assignEmployeeToDepartment();
                    break;
                case 7:
                    Payroll.displayAllSalaries(employees);
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee List");
        System.out.println("3. Update Employee Details");
        System.out.println("4. Delete Employee");
        System.out.println("5. Add Department");
        System.out.println("6. Assign Employee to Department");
        System.out.println("7. Display Salary Details");
        System.out.println("8. Exit");
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return input;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return input;
    }

    private static void addEmployee() {
        int id = getIntInput("Enter Employee ID: ");
        String name = getStringInput("Enter Employee Name: ");
        double basicSalary = getDoubleInput("Enter Basic Salary: ");
        double allowance = getDoubleInput("Enter Allowance: ");
        double deduction = getDoubleInput("Enter Deduction: ");
        Employee emp = new Employee(id, name, -1, basicSalary, allowance, deduction);
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("Employee List:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void updateEmployee() {
        int id = getIntInput("Enter Employee ID to update: ");
        Employee emp = findEmployeeById(id);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }
        String name = getStringInput("Enter new name (" + emp.getName() + "): ");
        if (!name.isEmpty()) {
            emp.setName(name);
        }
        double basicSalary = getDoubleInput("Enter new Basic Salary (" + emp.getBasicSalary() + "): ");
        emp.setBasicSalary(basicSalary);
        double allowance = getDoubleInput("Enter new Allowance (" + emp.getAllowance() + "): ");
        emp.setAllowance(allowance);
        double deduction = getDoubleInput("Enter new Deduction (" + emp.getDeduction() + "): ");
        emp.setDeduction(deduction);
        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee() {
        int id = getIntInput("Enter Employee ID to delete: ");
        Employee emp = findEmployeeById(id);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }
        employees.remove(emp);
        System.out.println("Employee deleted successfully.");
    }

    private static void addDepartment() {
        int id = getIntInput("Enter Department ID: ");
        String name = getStringInput("Enter Department Name: ");
        Department dept = new Department(id, name);
        departments.add(dept);
        System.out.println("Department added successfully.");
    }

    private static void assignEmployeeToDepartment() {
        int empId = getIntInput("Enter Employee ID: ");
        Employee emp = findEmployeeById(empId);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }
        int deptId = getIntInput("Enter Department ID: ");
        Department dept = findDepartmentById(deptId);
        if (dept == null) {
            System.out.println("Department not found.");
            return;
        }
        emp.setDeptId(deptId);
        dept.addEmployee(emp);
        System.out.println("Employee assigned to department successfully.");
    }

    private static Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    private static Department findDepartmentById(int id) {
        for (Department dept : departments) {
            if (dept.getId() == id) {
                return dept;
            }
        }
        return null;
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
