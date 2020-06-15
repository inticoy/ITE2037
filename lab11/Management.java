import java.util.ArrayList;

public class Management {

    public static <T extends Employee> T moveDepartment(T t, String department){
        t.setDepartment(department);
        return t;
    }

    public static <T extends Employee> T raiseSalary(T t, double rate){
        double salary = t.getSalary() * rate;
        t.setSalary(salary);
        return t;
    }

    public static <T extends Employee> int findIndexByEmpNum(ArrayList<T> tList, int employeeNum){
        int index = -1;
        for (int i = 0; i < tList.size(); i++) {
            if(tList.get(i).getEmployeeNum() == employeeNum)
                index = i;
        }
        return index;
    }

    public static <T extends Employee> ArrayList<T> raiseAllSalary(ArrayList<T> tList, double rate){
        double salary;
        for (int i = 0; i < tList.size(); i++) {
            salary = tList.get(i).getSalary() * rate;
            tList.get(i).setSalary(salary);
        }
        return tList;
    }
}
