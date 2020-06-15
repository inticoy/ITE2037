package practice02;

import java.util.Scanner;

public class Lab02 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] arr = input.split(" ");
		String lastName = arr[0].toUpperCase().substring(0, 1);
		lastName = lastName + arr[0].substring(1);
		//Last name
		String n1 = arr[1].substring(0, 1).toUpperCase();
	
		String output;
		
		if(arr.length == 4) {
			String n2 = arr[2].substring(0, 1).toUpperCase();
			String hw = arr[3];
			
			output = "Name Length(Korean) : " + (arr.length - 1) + "\n" + n1 + "." + n2 + "." + lastName + " submitted " + hw;
		}else {
			String hw = arr[2];
			output = "Name Length(Korean) : " + (arr.length - 1) + "\n" + n1 + "." + lastName + " submitted " + hw;
		}	
		
		System.out.println(output);
		
		scan.close();
	}

}
