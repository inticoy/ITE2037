package com.company;

public class Engineer extends Employee {
    private String workZone;
    private String project;

    public Engineer(String name, int employeeNum, String workZone, String project){
        super(name, employeeNum, "Engineering");
        this.workZone = workZone;
        this.project = project;
    }

    @Override
    public String toString() {
        return super.toString() + "\nlocation : [" + super.getDepartment() + "], zone : [" + this.workZone + "]";
    }
}
