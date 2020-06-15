public abstract class Employee {
    String name;
    int employeeNum;
    String department;
    int workHrs;
    double salary;

    public Employee(String name, int employeeNum){
        this.name = name;
        this.employeeNum = employeeNum;
        workHrs = 0;
        salary = 0;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getWorkHrs() {
        return workHrs;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        else if(getClass() != obj.getClass())
            return false;
        else{
            Employee employee = (Employee)obj;
            return name.equals(employee.name) && employeeNum == employee.employeeNum;
        }
    }

    @Override
    public String toString() {
        return "Name : [" + name + "]\nEmp# : [" + employeeNum + "]";
    }

    public void doWork(int hrs){
        this.workHrs += hrs;
        salary = getPaid();
    }
    public abstract double getPaid();

    public boolean equalPay(Employee emp){
        return salary  == emp.salary;
    }








}
