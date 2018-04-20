import humanResources.Department;
import humanResources.Employee;

import java.util.Scanner;

public class Main {
    private static Employee employee1 = new Employee("Вася", "Пупкин");
    private static Employee employee2 = new Employee("Денис", "Крикушин", "Студент", 1500);
    private static Employee employee3 = new Employee("Николай", "Пупкин", "Директор", 9999);
    private static Employee employee4 = new Employee("", "");
    private static Employee[] employees1 = {employee1, employee2, employee3};
    private static Department department1 = new Department("Тестовый департамент", employees1);
    private static Department[] departments1 = {department1};

    private static void printEmployee(Employee employee) {
        System.out.printf("Имя: %s   Фамилия: %s  Должность: %s  Зарплата: %d", employee.getFirstName(), employee.getSecondName(), employee.getJobTitle(), employee.getSalary());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какой тест запустить (1/2/3)?");
        int i = sc.nextInt();
        if (i == 1) {
            System.out.println("Нужно больше рабочих");
            System.out.print("Имя: ");
            employee4.setFirstName(sc.nextLine());
            System.out.print("Фамилия: ");
            employee4.setSecondName(sc.nextLine());
            System.out.print("Должность: ");
            employee4.setJobTitle(sc.nextLine());
            System.out.print("Зарплата: ");
            employee4.setSalary(sc.nextInt());
            department1.addEmployee(employee4);
            printEmployee(employee4);
        }
        if (i == 2) {

        } else {

        }
    }
}
