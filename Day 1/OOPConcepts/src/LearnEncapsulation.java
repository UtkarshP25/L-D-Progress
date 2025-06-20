import java.util.*;
class Employee{

    private String name;
    private int salary;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class LearnEncapsulation {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Employee Empobj = new Employee();
        System.out.println("Enter the id of the employee :");
        Empobj.setId(input.nextInt());
        System.out.println("Enter the salary of the employee :");
        Empobj.setSalary(input.nextInt());
        System.out.println("Enter the name of the employee :");
        Empobj.setName(input.next());

        System.out.println(Empobj.getName());
        System.out.println(Empobj.getSalary());
        System.out.println(Empobj.getId());

    }
}
