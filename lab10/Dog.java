public class Dog extends Animal implements Barkable{

    public Dog(){
        super("개");
    }
    public String bark(){
        return "멍멍";
    }
}
