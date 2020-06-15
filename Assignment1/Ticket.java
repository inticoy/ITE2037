public abstract class Ticket {
    private static int ticket_num = 0;

    private char[][] arr = new char[6][6]; //A - F, 1 - 6

    public Ticket() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = 'O';
            }
        }
    }
    // show_reservation 은 자식 클래스에서 표현
    abstract public String show_reservation();

    public char[][] getArr() {
        return arr;
    }

    public static int getTicket_num() {
        return ticket_num;
    }

    public boolean reserve(String seat) {
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

        if (arr[row_i][column_i] == 'O') {
            arr[row_i][column_i] = 'X';
            System.out.println("Ticket reserved!");
            ticket_num++;
            return true;
        } else {
            System.out.println("Already reserved seat.");
            return false;
        }

    }


}
