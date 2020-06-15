package com.company;

public class Employee {
    private String name;
    private int employeeNum;
    private String department;

    public Employee(){
        this.name = "";
        this.employeeNum = 0;
        this.department = "";
    }

    public Employee(String name, int employeeNum, String department){
        this.name = name;
        this.employeeNum = employeeNum;
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        else if(getClass() != obj.getClass())
            return false;
        else{
            Employee employee = (Employee)obj;
            return name.equals(employee.getName()) && employeeNum == employee.getEmployeeNum();
        }
    }
    @Override
    public String toString() {
        return "Name : [" + name + "]\nEmp# : [" + employeeNum + "]";
    }
}
