package avaj.launcher.Aircraft;

import avaj.launcher.Weather.WeatherTower;
import avaj.launcher.Weather.WriteFile;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    private static final String PLANENAME = "Helicopter";

    Helicopter(String name, Coordinates coordinates){super(name, coordinates);}

    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("SUN")){
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
//            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            WriteFile.getWriteFile().writeToFile(PLANENAME + "#" + this.name + "(" + this.id + "): To hot to fly");
        }
        else if (weather.equals("RAIN")){
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
//            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
            WriteFile.getWriteFile().writeToFile(PLANENAME + "#" + this.name + "(" + this.id + "): The rain is a bit disturbing");
        }
        else if (weather.equals("FOG")){
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
//            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
            WriteFile.getWriteFile().writeToFile(PLANENAME + "#" + this.name + "(" + this.id + "): Its a very bad weather today");
        }
        else if (weather.equals("SNOW")){
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
//            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            WriteFile.getWriteFile().writeToFile(PLANENAME + "#" + this.name + "(" + this.id + "): OHHHH what a very freezing day");
        }
        else{
            System.out.println("nothing fount");
//            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
        }
        if (this.coordinates.getHeight() <= 0){
            weatherTower.unregister(this);
            WriteFile.getWriteFile().writeToFile(PLANENAME + "#" + this.name + "(" + this.id + ") is landing");
            WriteFile.getWriteFile().writeToFile("Tower says : " + PLANENAME + "#" + this.name + "(" + this.id + ") unregistered from weather tower");
        }
    }
    public void registerTower(WeatherTower weatherTower){

        WriteFile.getWriteFile().writeToFile("Tower says: " + PLANENAME + "#" + this.name + "(" + this.id + ")" + " registered to weather tower");
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
