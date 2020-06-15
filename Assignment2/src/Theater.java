import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Theater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id, password;
        int menu;
        int movie;

        int newManager;

        // setting movies
        /*
        Movie[] movies = new Movie[8];
        movies[0] = new Movie("기생충", 0, 3);
        movies[1] = new Movie("감기", 3, 6);
        movies[2] = new Movie("해리포터", 6, 9);
        movies[3] = new Movie("라라랜드", 9, 12);
        movies[4] = new Movie("겨울왕국", 12, 15);
        movies[5] = new Movie("명탐정 코난", 15, 18);
        movies[6] = new Movie("어벤져스", 18, 21);
        movies[7] = new Movie("국제시장", 21, 24);
        */

        // new setting movies
        int numberOfMovies = 0;
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        try {
            FileReader rw = new FileReader("MovieList.txt");
            BufferedReader br = new BufferedReader(rw);
            numberOfMovies = Integer.parseInt(br.readLine());

            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                // split into list
                String[] tempInfo = tempLine.split("/");
                // add to arrayList
                movieArrayList.add(new Movie(tempInfo[0], tempInfo[1], tempInfo[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // setting users
        // User[] users = new User[10];
        // int user_count = 0;


        int member_count = 0;
        int current_member = 0;
        ArrayList<Member> memberArrayList = new ArrayList<>();
        try {
            FileReader rw = new FileReader("UserList.txt");
            BufferedReader br = new BufferedReader(rw);
            member_count = Integer.parseInt(br.readLine());

            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                // split into list
                String[] tempInfo = tempLine.split(" ");
                // add to arrayList

                int isManager = Integer.parseInt(tempInfo[0]);

                // if member is a manager
                if (isManager == 1) {
                    memberArrayList.add(new Manager(isManager, tempInfo[1], tempInfo[2]));
                } // if member is not a manager
                else {
                    memberArrayList.add(new User(isManager, tempInfo[1], tempInfo[2]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // setting reservations that already exist
        try {
            FileReader rw = new FileReader("Reservation.txt");
            BufferedReader br = new BufferedReader(rw);

            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                // split into list
                String[] tempInfo = tempLine.split("/");
                // ticket_num / title / seat / id

                // find movie
                int txtMovie;
                try{
                     txtMovie = 0;
                    for (Movie m : movieArrayList) {
                        if (m.getTitle().equals(tempInfo[1])) {
                            // reserved movie

                            m.file_reserved(tempInfo[2]);
                            break;
                        }
                        txtMovie++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }

                // find member
                int txtMember = 0;
                for(Member m: memberArrayList){
                    if(m.getId().equals(tempInfo[3])){
                        break;
                    }
                    txtMember++;
                }

                memberArrayList.get(txtMember).reservation("Ticket number: " +
                        Ticket.getTicket_num() +
                        " / " + movieArrayList.get(txtMovie).getTitle() +
                        " / " + movieArrayList.get(txtMovie).getStart() +
                        " - " + movieArrayList.get(txtMovie).getEnd() +
                        " / Seat: " + tempInfo[3]);
                // people info completed
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


        while (true) {
            System.out.println();
            System.out.println("******* 영화 예매 프로그램 *******");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 종료");
            System.out.print("메뉴를 선택해주세요 :");

            // try - catch
            try {
                menu = scanner.nextInt();
                if (menu != 1 && menu != 2 && menu != 3) {
                    InvalidMenuException e = new InvalidMenuException(menu);
                    throw e;
                }

            } catch (InvalidMenuException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Should be a number");
                scanner.nextLine();
                continue;
            }


            if (menu == 1) {
                // login
                System.out.print("******* 로그인 *******\nID : ");
                id = scanner.next();
                System.out.print("Password : ");
                password = scanner.next();

                // checking user
                boolean check = false;
                try {
                    for (int i = 0; i < member_count; i++) {
                        // check = users[i].checkUser(id, password);
                        check = memberArrayList.get(i).checkUser(id, password);
                        if (check) {
                            current_member = i;
                            break;
                        }
                    }
                    // if right, go to user program
                    // if wrong, go back to movie reserving program

                    if (!check) {
                        InvalidLoginException e = new InvalidLoginException();
                        throw e;
                        // continue;
                    }
                } catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                    continue;
                }


                // user program //
                while (true) {
                    System.out.println();
                    System.out.println("******* 유저 프로그램 *******");
                    System.out.println("1. 영화 목록");
                    System.out.println("2. 예매 확인");
                    System.out.println("3. 영화관 관리"); // added
                    System.out.println("4. 종료");
                    System.out.print("메뉴를 선택해주세요 : ");

                    try {
                        menu = scanner.nextInt();
                        if (menu != 1 && menu != 2 && menu != 3 && menu != 4) {
                            InvalidMenuException e = new InvalidMenuException(menu);
                            throw e;
                        }

                    } catch (InvalidMenuException e) {
                        System.out.println(e.getMessage());
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println("Should be a number");
                        scanner.nextLine();
                        continue;
                    }


                    if (menu == 1) {

                        while (true) {
                            /*for (int i = 0; i < 8; i++) {
                              movies[i].show_movie();
                            }*/

                            // changed version
                            System.out.println("******* 영화 목록 *******");
                            for (Movie m : movieArrayList) {
                                m.show_movie();
                            }
                            System.out.println("\n1. 예매");
                            System.out.println("2. 종료");
                            System.out.print("메뉴를 선택해주세요 : ");

                            try {
                                menu = scanner.nextInt();
                                if (menu != 1 && menu != 2) {
                                    InvalidMenuException e = new InvalidMenuException(menu);
                                    throw e;
                                }

                            } catch (InvalidMenuException e) {
                                System.out.println(e.getMessage());
                                continue;
                            } catch (InputMismatchException e) {
                                System.out.println("Should be a number");
                                scanner.nextLine();
                                continue;
                            }

                            if (menu == 1) {
                                while (true) {
                                    System.out.println("\n******* 영화 목록 *******");
                                    /*for (int i = 0; i < 8; i++) {
                                        System.out.print((i + 1) + ". "); // 순서는 +1
                                        movies[i].show_movie();
                                    }*/

                                    // changed version
                                    int i = 1;
                                    for (Movie m : movieArrayList) {
                                        System.out.print((i++) + ". "); // 순서는 1부터 시작
                                        m.show_movie();
                                    }
                                    System.out.print("\n예매할 영화를 선택해주세요: ");

                                    try {
                                        movie = scanner.nextInt();
                                        if (!(1 <= movie && movie <= numberOfMovies)) {
                                            InvalidMenuException e = new InvalidMenuException(movie);
                                            throw e;
                                        }

                                    } catch (InvalidMenuException e) {
                                        System.out.println(e.getMessage());
                                        continue;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Should be a number");
                                        scanner.nextLine();
                                        continue;
                                    }


                                    // 예매
                                    // String seat = movies[movie - 1].show_reservation();

                                    int check_manager = memberArrayList.get(current_member).getManager();
                                    String seat = movieArrayList.get(movie - 1).show_reservation(check_manager);
                                    if (seat.equals("Fail")) {
                                        break;
                                    } else {
                                        // reserve success
                                        /*users[current_user].reservation("Ticket number: " +
                                                Ticket.getTicket_num() +
                                                " / " + movies[movie - 1].getTitle() +
                                                " / " + movies[movie - 1].getStart() +
                                                " - " + movies[movie - 1].getEnd() +
                                                " / Seat: " + seat);*/
                                        memberArrayList.get(current_member).reservation("Ticket number: " +
                                                Ticket.getTicket_num() +
                                                " / " + movieArrayList.get(movie - 1).getTitle() +
                                                " / " + movieArrayList.get(movie - 1).getStart() +
                                                " - " + movieArrayList.get(movie - 1).getEnd() +
                                                " / Seat: " + seat);


                                        // write to text file
                                        try {
                                            FileWriter fw = new FileWriter("Reservation.txt", true);
                                            fw.write("\n" + Ticket.getTicket_num() + "/" +
                                                    movieArrayList.get(movie - 1).getTitle() + "/" +
                                                    seat + "/" +
                                                    memberArrayList.get(current_member).getId());
                                            fw.close();
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }


                                        break;
                                    }
                                }
                            } else if (menu == 2) {
                                System.out.println("유저 프로그램으로 돌아갑니다.");
                                break;
                            }
                            break;
                        }
                    } else if (menu == 2) {
                        // if he is manager
                        int check_manager = memberArrayList.get(current_member).getManager();
                        if (check_manager == 1) {
                            System.out.println("\n관리자가 발행한 티켓 수: " + memberArrayList.get(current_member).getTicket_count());
                            System.out.println("매출액: " + (memberArrayList.get(current_member).getTicket_count() * 10000) + "\n");
                        }

                        System.out.println("******* 예매 목록 *******");
                        //users[current_user].show_list();
                        memberArrayList.get(current_member).show_list();

                        scanner.nextLine();
                        while (true) {
                            System.out.println("Press enter to go back to User Program");
                            String enter = scanner.nextLine();
                            if (enter.length() == 0) break;
                        }

                    } else if (menu == 3) {
                        // if he is not a manager
                        int check_manager = memberArrayList.get(current_member).getManager();
                        try {
                            if (check_manager == 0) {
                                InvalidMenuException e = new InvalidMenuException();
                                throw e;
                            }
                        } catch (InvalidMenuException e) {
                            System.out.println(e.getMessage() + "\n");
                            continue;
                        }

                        //if he is a manager

                        // manager only program
                        while (true) {
                            System.out.println();
                            System.out.println("******* 영화관 관리 *******");
                            System.out.println("1. 영화관 정보");
                            System.out.println("2. 유저 정보");
                            System.out.println("3. 종료");
                            System.out.print("메뉴를 선택해주세요 : ");

                            try {
                                menu = scanner.nextInt();
                                if (menu != 1 && menu != 2 && menu != 3) {
                                    InvalidMenuException e = new InvalidMenuException(menu);
                                    throw e;
                                }

                            } catch (InvalidMenuException e) {
                                System.out.println(e.getMessage());
                                continue;
                            } catch (InputMismatchException e) {
                                System.out.println("Should be a number");
                                scanner.nextLine();
                                continue;
                            }

                            if (menu == 1) {
                                System.out.println("예매율 현황");
                                System.out.println("-----------------------------");
                                Integer[] rank = new Integer[numberOfMovies];
                                for (int i = 0; i < numberOfMovies; i++) {
                                    rank[i] = movieArrayList.get(i).getMovieTicketNum() * 10000 + i;
                                }

                                Arrays.sort(rank, Collections.reverseOrder());
                                int first = rank[0] % 10;
                                int second = rank[1] % 10;
                                int third = rank[2] % 10;

                                System.out.println("1위: " + movieArrayList.get(first).getTitle() + "(예매 좌석: " + movieArrayList.get(first).getMovieTicketNum() + ")");
                                System.out.println("2위: " + movieArrayList.get(second).getTitle() + "(예매 좌석: " + movieArrayList.get(second).getMovieTicketNum() + ")");
                                System.out.println("3위: " + movieArrayList.get(third).getTitle() + "(예매 좌석: " + movieArrayList.get(third).getMovieTicketNum() + ")");

                                System.out.println("------------------------------");
                                scanner.nextLine();
                                while (true) {
                                    System.out.println("Press enter to go back to Theater Management");
                                    String enter = scanner.nextLine();
                                    if (enter.length() == 0) break;
                                }
                            }
                            if (menu == 2) {
                                System.out.print("찾으려는 ID: ");
                                id = scanner.next();
                                check = false;
                                int find_i = -1;
                                int tmp = 0;
                                for (Member m : memberArrayList) {
                                    if (m.getId().equals(id)) {
                                        find_i = tmp;
                                        check = true;
                                        break;
                                    }
                                    tmp++;
                                }
                                if (check) {
                                    System.out.println(id + "고객님이 발행한 티켓 수: " + memberArrayList.get(find_i).getTicket_count());
                                    System.out.println("---------------------------------------------------------");
                                    memberArrayList.get(find_i).show_list();
                                    System.out.println("---------------------------------------------------------");

                                    scanner.nextLine();
                                    while (true) {
                                        System.out.println("Press enter to go back to User Program");
                                        String enter = scanner.nextLine();
                                        if (enter.length() == 0) break;
                                    }

                                } else {
                                    System.out.println(id + " 고객님이 존재하지 않습니다.");
                                }

                            }
                            if (menu == 3) {
                                System.out.println("유저 프로그램으로 돌아갑니다.");
                                break;
                            }
                        }


                    } else if (menu == 4) {
                        System.out.println("영화 예매 프로그램으로 돌아갑니다.");
                        break;
                    }
                }
            } else if (menu == 2) {
                // sign in
                System.out.println("******* 회원가입 *******");
                while (true) {
                    try {
                        System.out.print("ID : ");
                        id = scanner.next();
                        boolean DuplicatedId = false;
                        for (Member m : memberArrayList) {
                            if (m.getId().equals(id)) {
                                DuplicatedId = true;
                                break;
                            }
                        }
                        if (DuplicatedId) {
                            DuplicatedIdException e = new DuplicatedIdException(id);
                            throw e;
                        }
                        break;
                    } catch (DuplicatedIdException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                }


                System.out.print("Password : ");
                password = scanner.next();
                System.out.print("Are you manager? : ");
                newManager = scanner.nextInt();
                // add user
                // users[user_count] = new User(id, password);
                // user_count++;

                if (newManager == 1) {
                    memberArrayList.add(new Manager(newManager, id, password));
                } else {
                    memberArrayList.add(new User(newManager, id, password));
                }

                try {
                    FileWriter fw = new FileWriter("UserList.txt");
                    String tmp = ""+ ++member_count;
                    fw.write(tmp);
                    for(Member m : memberArrayList){
                        fw.write("\n" + m.getManager() + " " + m.getId() + " " + m.getPassword());
                    }
                    fw.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


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
