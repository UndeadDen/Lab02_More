package humanResources;

public class Department {

    private String name;
    private Employee[] employees;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public Department(String name) {
        this(name, DEFAULT_CAPACITY);
    }

    public Department(String name, int departmentSize) {
        this.name = name;
        this.employees = new Employee[departmentSize];
        this.size = 0;
    }

    public Department(String name, Employee[] employees) {
        this.name = name;
        this.employees = new Employee[employees.length]; //todo create new array
        System.arraycopy(employees, 0, this.employees, 0, employees.length);//todo use System.arrayCopy()
        for (int i = 0; i < employees.length; i++)
            if (employees[i] != null)
                this.size++;
    }

    public String getName() {
        return this.name;
    }

    public void addEmployee(Employee employee) {
        //todo remove code duplicates
        if (size >= employees.length) {
            Employee[] newEmployees = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, newEmployees, 0, size);
            this.employees = newEmployees;
        }
        this.employees[size] = employee;
        this.size++;

    }

    public boolean fireEmployee(String firstName, String secondName) {
        for (int i = 0; i < size; i++)
            if (this.employees[i].getFirstName().equals(firstName) && this.employees[i].getSecondName().equals(secondName)) {
                //todo System.arraycopy()
                System.arraycopy(employees, i+1, employees, i, size-i-1);
                this.employees[size - 1] = null;
                size--;
                return true;
            }
        return false;
    }

    public int getSize() {
        return size;
    }

    public Employee[] getEmployees() {
        Employee[] onlyEmployees = new Employee[this.size];
        System.arraycopy(employees, 0, onlyEmployees, 0, size);
        return onlyEmployees;
    }

    public Employee[] employeesByJobTitle(String jobTitle) {
        Employee[] newEmployees = new Employee[employeesQuantity(jobTitle)];

        int employeeCounter = 0; //todo rename j

        for (int i = 0; i < this.size; i++) {
            if (employees[i].getJobTitle().equals(jobTitle)) {
                newEmployees[employeeCounter] = this.employees[i];
                employeeCounter++;
            }
        }
        return newEmployees;
    }

    public int employeesQuantity(String jobTitle) {
        int numberOfEmployeesWithSetJobTitle = 0;
        for (int i = 0; i < this.size; i++) {
            if (employees[i].getJobTitle().equals(jobTitle)) {
                numberOfEmployeesWithSetJobTitle++;
            }
        }
        return numberOfEmployeesWithSetJobTitle;
    }

    public Employee[] employeesSortedBySalary() {
        //todo use getEmployees()
        Employee[] onlyEmployees = getEmployees();
        System.arraycopy(employees, 0, onlyEmployees, 0, size);
        for (int i = 0; i < this.size - 1; i++) {
            for (int j = i + 1; j < this.size; j++) {
                if (onlyEmployees[i].getSalary() < onlyEmployees[j].getSalary()) {
                    Employee x = onlyEmployees[j];
                    onlyEmployees[j] = onlyEmployees[i];
                    onlyEmployees[i] = x;
                }
            }
        }
        return onlyEmployees;
    }

    public Employee bestEmployee() {
        if (size > 0) {
            Employee employeeWithHighestSalary = employees[0];
            for (int i = 1; i < this.size; i++) {
                if (employees[i].getSalary() > employeeWithHighestSalary.getSalary()) {
                    employeeWithHighestSalary = employees[i];
                }
            }
            return employeeWithHighestSalary;
        } else return null;
    }

    public boolean hasEmployee(String firstName, String secondName) {
        for (int i = 0; i < size; i++)
            if (this.employees[i].getFirstName().equals(firstName) && this.employees[i].getSecondName().equals(secondName)) {
                return true;
            }
        return false;
    }
}
