import java.util.Scanner;

public class Movie extends Ticket {

    private String title;
    private String start, end;

    // new variable
    private int movieTicketNum;


    // public Movie(String title, int start, int end)
    public Movie(String title, String start, String end) {
        super();
        this.title = title;
        this.start = start + ":00";
        this.end = end + ":00";
        movieTicketNum = 0;
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

    public int getMovieTicketNum() {
        return movieTicketNum;
    }

    public void show_movie() {
        System.out.println("제목 : " + title + " / 상영시간 : " + start + " - " + end);
    }

    // new
    public void file_reserved(String seat){
        char row, column;
        int row_i = 0, column_i = 0;
        row = seat.charAt(0);
        column = seat.charAt(1);

        switch (row) {
            case 'A':
                row_i = 0;
                break;
            case 'B':
                row_i = 1;
                break;
            case 'C':
                row_i = 2;
                break;
            case 'D':
                row_i = 3;
                break;
            case 'E':
                row_i = 4;
                break;
            case 'F':
                row_i = 5;
                break;
        }
        switch (column) {
            case '1':
                column_i = 0;
                break;
            case '2':
                column_i = 1;
                break;
            case '3':
                column_i = 2;
                break;
            case '4':
                column_i = 3;
                break;
            case '5':
                column_i = 4;
                break;
            case '6':
                column_i = 5;
                break;
        }

        file_reserved_ticket(row_i, column_i);
        movieTicketNum++;
    }


    @Override
    public String show_reservation(int isManager) {
        if (isManager == 1) {
            double rate = (double) movieTicketNum * 100 / 36;
            System.out.println("\n\"" + title + "\" 영화의 좌석 예매 점유율: " + String.format("%.2f", rate) + "%");
            System.out.println("\"" + title + "\" 영화의 총 매출액: " + (movieTicketNum  * 10000) + "\n");
        } else {
            System.out.println("제목 : " + title + " / 상영시간 : " + start + " - " + end);
        }
        System.out.println("******* 좌 석 *******");
        System.out.println("  1 2 3 4 5 6");
        for (int i = 0; i < 6; i++) {
            switch (i) {
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

        if (reserve_check) {
            movieTicketNum++;
            return seat;
        } else return "Fail";
    }
}
