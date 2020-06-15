public class Engineer extends Employee{

    public static int initial_manager_number = 2000;
    public static String initial_manager_dept = "Computational Management";
    public static int initial_manager_salary = 3300;


    public Engineer(String name){
        setName(name);
        setDepartment(initial_manager_dept);
        setEmployeeNum(++initial_manager_number);
        setSalary(initial_manager_salary);
    }
}
