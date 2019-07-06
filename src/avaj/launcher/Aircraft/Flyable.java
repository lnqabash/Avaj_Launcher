package avaj.launcher.Aircraft;

import avaj.launcher.Weather.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower Weathertower);
}
