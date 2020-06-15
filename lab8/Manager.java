public class Manager extends Employee {
    double overtimeRate;
    double rate;
    int regularHrs;
    public Manager(String name, int employeeNum){
        super(name, employeeNum);
        rate = 5.0;
        overtimeRate = 8.0;
        regularHrs = 40;
        department = "Management";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (getClass() != obj.getClass())
            return false;
        else {
            Manager manager = (Manager)obj;
            return name.equals(manager.name) && employeeNum == manager.employeeNum;
        }
    }

    @Override
    public String toString() {
        return "Name : [" + name + "]\nEmp# : [" + employeeNum + "]\nDept : [" + department + "]\n";
    }

    public double getPaid(){
        int overtimeHrs = workHrs - regularHrs;
        if(workHrs < 40){
            return workHrs * rate;
        }else{
            return (regularHrs * rate) + (overtimeHrs * overtimeRate);
        }
    }
}
