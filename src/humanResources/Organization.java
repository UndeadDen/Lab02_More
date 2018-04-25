package humanResources;

//todo use System.arraycopy()
public class Organization {
    private String name;
    private Department[] departments;
    private int size;
    private static final int DEFAULT_ORGANIZATION_SIZE = 10;

    public Organization(String name) {
        this.name = name;
        this.departments = new Department[DEFAULT_ORGANIZATION_SIZE];
    }

    public Organization(String name, Department[] departments) {
        this.name = name;
        this.departments = departments;
        for (int i = 0; i < departments.length; i++)
            if (departments[i] != null)
                this.size++;
    }

    public void addDepartment(Department department) {
        //todo remove code duplicates
        if (size >= departments.length) {
            Department[] newDepartments = new Department[departments.length * 2];
            System.arraycopy(departments, 0, newDepartments, 0, size);
            this.departments = newDepartments;
        }
        this.departments[size] = department;
        this.size++;
    }

    public boolean fireDepartment(String departmentName) {
        for (int i = 0; i < size; i++)
            if (departments[i].getName().equals(departmentName)) {
                System.arraycopy(departments, i+1, departments, i, size-i-1);
                departments[size - 1] = null;
                size--;
                return true;
            }
        return false;
    }

    public Department getDepartment(String departmentName) {
        for (int i = 0; i < size; i++)
            if (this.departments[i].getName().equals(departmentName)) {
                return departments[i];
            }
        return null;
    }

    public Department[] getDepartments() {
        Department[] newDepartments = new Department[size];
        System.arraycopy(departments, 0, newDepartments, 0, size);
        return newDepartments;
    }

    public int getSize() {
        return size;
    }

    public int employeesQuantity() {
        int numberOfEmployees = 0;
        for (int i = 0; i < size; i++) {
            numberOfEmployees += departments[i].getSize();
        }
        return numberOfEmployees;
    }

    public int employeesQuantity(String jobTitle) {
        int numberOfEmployees = 0;
        for (int i = 0; i < size; i++) {
            numberOfEmployees += departments[i].employeesQuantity(jobTitle);
        }
        return numberOfEmployees;
    }

    public Employee bestEmployee() {
        if (size > 0) {
            Employee employeeWithHighestSalary = departments[0].bestEmployee();
            for (int i = 1; i < this.size; i++) {
                Employee bestEmployee = departments[i].bestEmployee();//todo Employee bestEmployee = dep[i].bestEMployee();
                if (bestEmployee.getSalary() > employeeWithHighestSalary.getSalary()) {
                    employeeWithHighestSalary = bestEmployee;
                }
            }
            return employeeWithHighestSalary;
        }
        return null;
    }

    public Department getEmployeeDepartment(String firstName, String secondName) {
        for (int i = 0; i < size; i++) {
            if (departments[i].hasEmployee(firstName, secondName))
                return departments[i];
        }
        return null;
    }
}
