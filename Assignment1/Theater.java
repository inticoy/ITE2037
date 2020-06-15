import java.util.Scanner;

public class Theater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id, password;
        int menu;
        int movie;
        int current_user = 0;

        // setting movies
        Movie[] movies = new Movie[8];
        movies[0] = new Movie("기생충", 0, 3);
        movies[1] = new Movie("감기", 3, 6);
        movies[2] = new Movie("해리포터", 6, 9);
        movies[3] = new Movie("라라랜드", 9, 12);
        movies[4] = new Movie("겨울왕국", 12, 15);
        movies[5] = new Movie("명탐정 코난", 15, 18);
        movies[6] = new Movie("어벤져스", 18, 21);
        movies[7] = new Movie("국제시장", 21, 24);


        // setting users
        User[] users = new User[10];
        int user_count = 0;

        while (true) {
            System.out.println();
            System.out.println("******* 영화 예매 프로그램 *******");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 종료");
            System.out.print("메뉴를 선택해주세요 :");

            menu = scanner.nextInt();


            if (menu == 1) {
                // login
                System.out.print("******* 로그인 *******\nID : ");
                id = scanner.next();
                System.out.print("Password : ");
                password = scanner.next();

                // checking user
                boolean check = false;

                for (int i = 0; i < user_count ; i++) {
                    check = users[i].checkUser(id, password);
                    if(check){
                        current_user = i;
                        break;
                    }
                }
                // if right, go to user program
                // if wrong, go back to movie reserving program
                if(!check){
                    System.out.println("회원 정보가 일치하지 않습니다.");
                    continue;
                }

                while (true) {
                    System.out.println();
                    System.out.println("******* 유저 프로그램 *******");
                    System.out.println("1. 영화 목록");
                    System.out.println("2. 예매 확인");
                    System.out.println("3. 종료");
                    System.out.print("메뉴를 선택해주세요 : ");

                    menu = scanner.nextInt();



                    if (menu == 1) {

                        while(true) {
                            System.out.println("******* 영화 목록 *******");
                            for (int i = 0; i < 8; i++) {
                                movies[i].show_movie();
                            }
                            System.out.println("\n1. 예매");
                            System.out.println("2. 종료");
                            System.out.print("메뉴를 선택해주세요 : ");

                            menu = scanner.nextInt();
                            if (menu == 1) {
                                System.out.println("******* 영화 목록 *******");
                                for (int i = 0; i < 8; i++) {
                                    System.out.print((i + 1) + ". "); // 순서는 +1
                                    movies[i].show_movie();
                                }
                                System.out.print("\n예매할 영화를 선택해주세요: ");

                                movie = scanner.nextInt();
                                // 예매
                                String seat = movies[movie - 1].show_reservation();
                                if (seat.equals("Fail")) {
                                    break;
                                } else {
                                    users[current_user].reservation("Ticket number: " +
                                            Ticket.getTicket_num() +
                                            " / " + movies[movie - 1].getTitle() +
                                            " / " + movies[movie - 1].getStart() +
                                            " - " + movies[movie - 1].getEnd() +
                                            " / Seat: " + seat);
                                    break;
                                }
                            } else if (menu == 2) {
                                System.out.println("유저 프로그램으로 돌아갑니다.");
                                break;
                            }
                        }
                    } else if (menu == 2) {
                        System.out.println("******* 예매 목록 *******");
                        users[current_user].show_list();



                        scanner.nextLine();
                        while(true) {
                            System.out.println("Press enter to go back to User Program");
                            String enter = scanner.nextLine();
                            if (enter.length() == 0) break;
                        }

                    } else if (menu == 3) {
                        System.out.println("영화 예매 프로그램으로 돌아갑니다.");
                        break;
                    }
                }
            } else if (menu == 2) {
                // sign in
                System.out.print("******* 회원가입 *******\nID : ");
                id = scanner.next();
                System.out.print("Password : ");
                password = scanner.next();

                // add user
                users[user_count] = new User(id, password);
                user_count++;

                continue;
            } else if (menu == 3) {
                System.out.println("영화 예매 프로그램을 종료합니다.");
                break;
            } else {
                continue;
            }
        }

        scanner.close();
    }
}
