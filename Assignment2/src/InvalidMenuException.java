public class InvalidMenuException extends Exception {
    public InvalidMenuException(){
        super("Invalid Access");
    }
    public InvalidMenuException(int menu){
        super(menu + " is an invalid menu number");
    }
}
