public class City {
    private String name;
    private int location_x, location_y;

    City(String name, int location_x, int location_y){
        this.name = name;
        this.location_x = location_x;
        this.location_y = location_y;
    }

    City(String name){
        this.name = name;
        this.location_x = (int)(Math.random() * 360) + 1;
        this.location_y = (int)(Math.random() * 360) + 1;
    }

    public String getName(){
        return this.name;
    }
    public int getLocation_x(){
        return this.location_x;
    }
    public int getLocation_y(){
        return this.location_y;
    }
    public Boolean equals(City city){
        if(city.getName().equals(this.name) && city.getLocation_x() == this.location_x && city.getLocation_y() == this.location_y){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return name + ", " + location_x + ", " + location_y;
    }

    public static double distance(City city1, City city2){
        double left = Math.pow(city1.getLocation_x() - city2.getLocation_x(), 2);
        double right = Math.pow(city1.getLocation_y() - city2.getLocation_y(), 2);
        double ret = Math.sqrt(left+right);
        return ret;
    }


}