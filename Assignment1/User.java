public class User {
    private String id;
    private String password;


    private int ticket_count;
    private String[] arr = new String[10];


    public User(String id, String password) {
        this.id = id;
        this.password = password;
        this.ticket_count = 0;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkUser(String id, String password){
        return id.equals(this.id) && password.equals(this.password);
    }

    public void reservation(String info){
        arr[this.ticket_count] = info;
        this.ticket_count++;
    }

    public void show_list(){
        for (int i = 0; i < ticket_count; i++) {
            System.out.println(arr[i]);
        }
    }
}