package practice03;

public class Employee {
	
	private String name, position;
	private int age, salary, vacationDays;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
		position = "Employee";
		salary = 5000;
		vacationDays = 20;
	}
	public Employee(String name, int age, String position, int salary) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		vacationDays = 20;
	}
	public Employee(String name, int age, String position, int salary, int vacationDays) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = vacationDays;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(int salary){
		this.salary = salary;
	}
	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
	
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public int getAge() {
		return age;
	}
	public int getSalary() {
		return salary;
	}
	public int getVacationDays() {
		return vacationDays;
	}
	
	public boolean equals(Employee another) {
		if(this.name.equals(another.name) && this.age == another.age && this.position.equals(another.position)) return true;
		else return false;
	}
	public String toString() {
		return "Name : " + name + ", Age : " + age + ", Position : "+ position + ", Salary : "+ salary + ", VacationDays : " + vacationDays;
	}

	public boolean vacation(int days) {
		if(vacationDays < days) {
			System.out.println("남은 휴가 일수가 부족합니다.");
			return false;
		}else {
			vacationDays -= days;
			System.out.println("휴가를 사용하였습니다. 남은 휴가 일 수 : " + vacationDays);
			return true;
		}
	}
	
}
