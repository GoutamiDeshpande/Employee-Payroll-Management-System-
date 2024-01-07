import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    //implement subclasses
    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee[name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem{
    private List<Employee> employeeList;
    public PayrollSystem(){
        employeeList=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args){
        PayrollSystem payrollSystem=new PayrollSystem();

        FullTimeEmployee emp1=new FullTimeEmployee("Abhishek",1,30000.0);
        FullTimeEmployee emp2=new FullTimeEmployee("Bobby",2,35000.0);
        FullTimeEmployee emp3=new FullTimeEmployee("Chintu",3,40000.0);
        FullTimeEmployee emp4=new FullTimeEmployee("Deepak",4,45000.0);
        FullTimeEmployee emp5=new FullTimeEmployee("Goutami",5,50000.0);

        PartTimeEmployee emp6=new PartTimeEmployee("Huma",6,10,200.0);
        PartTimeEmployee emp7=new PartTimeEmployee("Jiya",7,20,200.0);
        PartTimeEmployee emp8=new PartTimeEmployee("Siya",8,30,200.0);
        PartTimeEmployee emp9=new PartTimeEmployee("Arun",9,40,200.0);
        PartTimeEmployee emp10=new PartTimeEmployee("Zyan",10,50,200.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);
        payrollSystem.addEmployee(emp8);
        payrollSystem.addEmployee(emp9);
        payrollSystem.addEmployee(emp10);

        System.out.println("Initial employees Details:\n");
        payrollSystem.displayEmployees();

        System.out.println("Removing Employee.....\n");
        payrollSystem.removeEmployee(6);

        System.out.println("Remaining Employees Details:\n");
        payrollSystem.displayEmployees();
    }
}