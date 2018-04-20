package humanResources;

public class Employee {
    private String firstName, secondName, jobTitle;
    private int salary;
    private static final int DEFAULT_SALARY = 0;
    private static final String DEFAULT_JOB_TITLE = "";

    public Employee (String firstName, String secondName){
        this(firstName, secondName, DEFAULT_JOB_TITLE, DEFAULT_SALARY);
    }

    public Employee (String firstName, String secondName, String jobTitle, int salary){
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public String getJobTitle(){
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    public int getSalary(){
        return this.salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }
}