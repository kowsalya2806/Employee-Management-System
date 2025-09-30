public class Employee {
    private int id;
    private String name;
    private int deptId;
    private double basicSalary;
    private double allowance;
    private double deduction;

    public Employee(int id, String name, int deptId, double basicSalary, double allowance, double deduction) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.deduction = deduction;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    // Calculate net salary (basic + allowance - deduction)
    public double calculateNetSalary() {
        return basicSalary + allowance - deduction;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptId=" + deptId +
                ", basicSalary=" + basicSalary +
                ", allowance=" + allowance +
                ", deduction=" + deduction +
                ", netSalary=" + calculateNetSalary() +
                '}';
    }
}
