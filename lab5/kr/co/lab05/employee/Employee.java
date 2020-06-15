package kr.co.lab05.employee;

public class Employee {
    private String name;
    private double yearly_salary, monthly_salary, balance;

    public Employee(String name, double yearly_salary) {
        this.name = name;
        this.yearly_salary = yearly_salary;
        this.monthly_salary = yearly_salary / 12;
        this.balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public void increaseYearlySalary(int byPercent) {
        this.yearly_salary = this.yearly_salary * (1 + ((double) byPercent) / 100);
        this.monthly_salary = this.yearly_salary / 12;
    }

    public void receiveSalary() {
        this.balance += this.monthly_salary;
    }

    public String toString() {
        double year = Math.round(this.yearly_salary * 10) / 10;
        double month = Math.round(this.monthly_salary * 10) / 10;
        double bal = Math.round(this.balance * 10) / 10;
        return "이름: " + name + ", 연봉: " + year + ", 월급: " + month + ",   재산: " + bal;
    }


}
