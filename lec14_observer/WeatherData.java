import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList observers;
    private float temparature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    public void notifyObservers(){
        for(Object i : observers){
            Observer o = (Observer)i;
            o.update(temparature, humidity, pressure);
        }
    }

    public void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temparature, float humidity, float pressure){
        this.temparature = temparature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
