import humanResources.Department;
import humanResources.Employee;
import humanResources.Organization;

import java.util.Scanner;

public class Main {
    private static Employee employee1 = new Employee("Вася", "Пупкин");
    private static Employee employee2 = new Employee("Денис", "Крикушин", "Студент", 1500);
    private static Employee employee3 = new Employee("Николай", "Пупкин", "Директор", 99999);
    private static Employee employee4 = new Employee("Иван", "Иванов", "Уборщик", 10000);
    private static Employee employee5 = new Employee("", "");
    private static Employee[] employees1 = {employee1, employee2, employee3};
    private static Employee[] employees2 = {employee4};
    private static Department department1 = new Department("Тестовый департамент", employees1);
    private static Department department2 = new Department("Ещё один департамент", employees2);
    private static Department[] departments = {department1};
    private static Organization organization = new Organization("Тестовая организация", departments);

    private static void printEmployee(Employee employee) {
        System.out.printf("Имя: %s   Фамилия: %s  Должность: %s  Зарплата: %d \n", employee.getFirstName(), employee.getSecondName(), employee.getJobTitle(), employee.getSalary());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какой тест запустить (1/2)?");
        int i = sc.nextInt();
        if (i == 1) {
            System.out.println("Нужно больше рабочих");
            System.out.print("Имя: ");
            employee5.setFirstName(sc.nextLine());
            System.out.print("Фамилия: ");
            employee5.setSecondName(sc.nextLine());
            System.out.print("Должность: ");
            employee5.setJobTitle(sc.nextLine());
            System.out.print("Зарплата: ");
            employee5.setSalary(sc.nextInt());
            department1.addEmployee(employee5);
            printEmployee(employee5);
        }
        else {
            organization.addDepartment(department2);
            System.out.printf("В организации находится %d департаментов\n", organization.getSize());
            System.out.printf("В организации находится %d работников\n", organization.employeesQuantity());
            System.out.printf("В организации находится %d работников на должности Директор\n", organization.employeesQuantity("Директор"));
            System.out.printf("Наибольшую зарплату имеет %s %s в размере %d \n", organization.bestEmployee().getFirstName(), organization.bestEmployee().getSecondName(), organization.bestEmployee().getSalary());
            organization.fireDepartment(organization.getDepartment("Тестовый департамент").getName());
            System.out.printf("В организации находится %d департаментов\n", organization.getSize());
            System.out.printf("В организации находится %d работников\n", organization.employeesQuantity());
            System.out.printf("В организации находится %d работников на должности Директор\n", organization.employeesQuantity("Директор"));
            System.out.printf("Наибольшую зарплату имеет %s %s в размере %d \n", organization.bestEmployee().getFirstName(), organization.bestEmployee().getSecondName(), organization.bestEmployee().getSalary());
        }
    }
}
