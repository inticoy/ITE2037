package practice03;

public class EmployeeManager {

	public static void main(String[] args) {
		
		Employee James = new Employee("James Wright", 42, "Manager", 20000);
		System.out.println(James.toString());
		Employee Amy = new Employee("Amy Smith", 27 , "Design Coordinator", 8000, 15);
		System.out.println(Amy.toString());
		Employee Peter = new Employee("Peter Coolidge", 32, "Assistant Manager", 12000, 7);
		System.out.println(Peter.toString());
		Employee John = new Employee("John Doe", 22, "Engineer", 10000, 10);
		System.out.println(John.toString());
		
		Employee newGuy = new Employee("Geonwoo Yun", 21);
		System.out.println(newGuy.equals(Amy));
		
		James.vacation(10);
		Peter.vacation(10);
		System.out.println(James.toString());
		System.out.println(Amy.toString());
		System.out.println(Peter.toString());
		System.out.println(John.toString());
	}

}
