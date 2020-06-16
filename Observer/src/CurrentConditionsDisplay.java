public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temparature;
    private float humidity;
    private Subject weatherData;

    public  CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temparature, float humidity, float pressure){
        this.temparature = temparature;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("Current conditions: " + temparature
        + "F degrees and " + humidity + "% humidity.");
    }
}
