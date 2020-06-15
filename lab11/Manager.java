public class Manager extends Employee {
    public static int initial_manager_number = 1000;
    public static String initial_manager_dept = "Sales Management";
    public static int initial_manager_salary = 3000;


    public Manager(String name){
        setName(name);
        setDepartment(initial_manager_dept);
        setEmployeeNum(++initial_manager_number);
        setSalary(initial_manager_salary);
    }
}
