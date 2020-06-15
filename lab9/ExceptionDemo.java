import java.util.Scanner;

public class ExceptionDemo{
    public static void main(String[] args) {
        Employee employee = new Employee("Yoon");

        while(true){
            System.out.print(employee.getWorkDay() + "일차 근무 시간을 입력하세요 : ");

            Scanner scanner = new Scanner(System.in);
            int hours = 0;
            try{
                hours = scanner.nextInt();
                if(hours < 0){

                    NegativeException negativeException = new NegativeException();
                    throw negativeException;
                }else if(hours == 0){
                    Exception e = new Exception("Program Exit");
                    throw e;
                }else if(hours > 24){
                    TooMuchStuffException tooMuchStuffException = new TooMuchStuffException(hours);
                    throw tooMuchStuffException;
                }else{
                    employee.addWorkHours(hours);
                    employee.addWorkDay();
                    System.out.println(employee.getName());
                    System.out.println(employee.getWorkHours());
                    System.out.println("No exception has been occurred");
                }
            }catch(NegativeException e) {
                System.out.println(e.getMessage());
            }catch(TooMuchStuffException e) {
                System.out.println(e.getInputNum() + ", "+ e.getMessage());
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.exit(0);
            }finally {
                System.out.println("End of try-catch statement");
            }




        }
    }
}

