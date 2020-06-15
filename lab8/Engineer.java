public class Engineer extends Employee {
    double rate;

    public Engineer(String name, int employeeNum) {
        super(name, employeeNum);
        rate = 4.0;
        department = "Engineering";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (getClass() != obj.getClass())
            return false;
        else {
            Engineer engineer = (Engineer) obj;
            return name.equals(engineer.name) && employeeNum == engineer.employeeNum;
        }
    }

    @Override
    public String toString() {
        return "Name : [" + name + "]\nEmp# : [" + employeeNum + "]\nDept : [" + department + "]\n";
    }

    public double getPaid() {
        return workHrs * rate;
    }
}
