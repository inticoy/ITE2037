package com.company;


public class Manager extends Employee {
    private int officeNum;
    private String team;

    public Manager(String name, int employeeNum, int officeNum, String team){
        super(name, employeeNum, "Management");
        this.officeNum = officeNum;
        this.team = team;
    }

    @Override
    public String toString() {
        return super.toString() + "\nlocation [" + super.getDepartment() + "], office : [" + this.officeNum + "]";
    }
}
