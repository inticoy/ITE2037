public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        // can add new Objects or new Class that implements Observer and DisplayElement.




        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
