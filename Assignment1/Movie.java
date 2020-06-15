import java.util.Scanner;

public class Movie extends Ticket {

    private String title;
    private String start, end;


    public Movie(String title, int start, int end) {
        super();
        this.title = title;
        this.start = start + ":00";
        this.end = end + ":00";
    }

    public String getTitle() {
        return title;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void show_movie(){
        System.out.println("제목 : " + title + " / 상영시간 : " + start + " - " + end);
    }

    @Override
    public String show_reservation() {
        System.out.println("제목 : " + title + " / 상영시간 : " + start + " - " + end);
        System.out.println("******* 좌 석 *******");
        System.out.println("  1 2 3 4 5 6");
        for (int i = 0; i < 6; i++) {
            switch(i){
                case 0:
                    System.out.print("A ");
                    break;
                case 1:
                    System.out.print("B ");
                    break;
                case 2:
                    System.out.print("C ");
                    break;
                case 3:
                    System.out.print("D ");
                    break;
                case 4:
                    System.out.print("E ");
                    break;
                case 5:
                    System.out.print("F ");
                    break;
            }
            for (int j = 0; j < 6; j++) {
                System.out.print(getArr()[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("******************");
        System.out.print("좌석을 선택해주세요(ex A1) : ");

        Scanner scanner = new Scanner(System.in);
        String seat = scanner.next();
        boolean reserve_check = super.reserve(seat);

        if(reserve_check) return seat;
        else return "Fail";
    }
}
