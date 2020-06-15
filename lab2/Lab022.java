package practice02;

import java.util.Scanner;

public class Lab022 {
	
	static String ret(int num) {
		num += 1;
		if((num % 100) / 10 == 1) return num + "th";
		switch(num % 10) {
			case 1 : return num + "st";
			case 2 : return num + "nd";
			case 3 : return num + "rd";
		}
		return num + "th";
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] arr = input.toLowerCase().split(" ");
		String output;
		int num = arr.length;
		int sum = 0;
		
		for(int i = 0; i < num; i++) {
			switch(arr[i]) {
			case "a": 
				arr[i] = "100";
				break;
			case "b": 
				arr[i] = "90";
				break;
			case "c": 
				arr[i] = "80";
				break;
			case "d": 
				arr[i] = "70";
				break;
			case "f": 
				arr[i] = "0";
				break;
			}
		
			output = ret(i) + " student's score is " + arr[i];
			System.out.println(output);
			sum += Integer.parseInt(arr[i]);
		}
		
		double avr = sum / (double) num;
		System.out.println("This class's average = " + String.format("%.2f", avr));	
		scan.close();
	}

}
