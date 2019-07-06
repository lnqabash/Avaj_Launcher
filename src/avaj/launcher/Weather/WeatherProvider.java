package avaj.launcher.Weather;

import avaj.launcher.Aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = null;

    private String[] weather = {

            "RAIN",
            "FOG",
            "SUN",
            "SNOW"
    };

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        int random = rand.nextInt(4);
        return (weather[random]);
    }
}
