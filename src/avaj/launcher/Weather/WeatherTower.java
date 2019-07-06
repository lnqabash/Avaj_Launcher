package avaj.launcher.Weather;

import avaj.launcher.Aircraft.Coordinates;

public class WeatherTower extends Tower {

    public WeatherTower(){
        // member function of a class
    }

    void changeWeather(){
        this.conditionsChanged();
    }

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

}
