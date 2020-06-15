package kr.co.lab05.manager;

import kr.co.lab05.employee.Employee;

import java.time.LocalDate;

public class EmployeeManager {
    public static void main(String[] args) {
        Employee employee = new Employee("Yoon", 4500);


        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();


        System.out.println("계약일: " + year + "-" + month + "-" + day);
        System.out.println(employee.toString());

        int imonth = (int)(Math.random() * 12 + 1);
        int year_count = 1;
        while(employee.getBalance() <= 20000){

            if(month == imonth){
                employee.receiveSalary();
                System.out.println(year_count + "년차 "+ imonth +"월에 인센티브를 받았습니다.");
            }
            employee.receiveSalary();
            month++;

            if(month == 13){

                month = 1;
                int percent = (int)(Math.random() * 10 + 1);
                employee.increaseYearlySalary(percent);
                System.out.println(year_count +"년차 연봉이 "+ percent + "% 인상되었습니다.");
                imonth = (int)(Math.random() * 12 + 1);
                year_count++;
                year++;
            }
        }
        System.out.println("계약일: " + year + "-" + month + "-" + day);
        System.out.println(employee.toString());


    }
}
