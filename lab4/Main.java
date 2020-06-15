public class Main {
    public static void main(String[] args) {

        City seoul = new City("Seoul", 23, 45);
        System.out.println(seoul.toString());
        City paris = new City("Paris", 123, 41);
        System.out.println(paris.toString());
        City racoon = new City("Racoon City");
        System.out.println(racoon.toString());
        City mega = new City("Mega City");
        System.out.println(mega.toString());

        System.out.println(seoul.getName() + "-" + paris.getName() + " : " + City.distance(seoul, paris));
        System.out.println(seoul.getName() + "-" + racoon.getName() + " : " + City.distance(seoul, racoon));
        System.out.println(paris.getName() + "-" + mega.getName() + " : " + City.distance(paris, mega));
    }


}
