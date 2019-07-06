package avaj.launcher.Weather;

import avaj.launcher.Aircraft.AircraftFactory;
import avaj.launcher.Aircraft.Flyable;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.*;

public class Simulator {

    private static WeatherTower weatherTower;
    private static List<Flyable> fly = new ArrayList<>();

    public static void main(String[] arg) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    System.err.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    if (line.split(" ").length != 5) {
                        System.err.println("5 parameters needed");
                        return;
                    }
                    if (line.split(" ")[0].equals("JetPlane") || line.split(" ")[0].equals("Helicopter") ||
                            line.split(" ")[0].equals("Baloon")) {
                        Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                                check(line.split(" ")[2]), check(line.split(" ")[3]),
                                check(line.split(" ")[4]));
                        if (flyable != null)
                            fly.add(flyable);
                    }
                }

                for (Flyable flyable : fly) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changeWeather();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't find any file ");
        } catch (IOException e) {
            System.err.println("There was an error while reading the file " + arg[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Specify simulation file");
        } finally {
            WriteFile.getWriteFile().close();
        }
    }

    private static int check(String number){

        int num;
        num = Integer.parseInt(number);
        if (num < 0) {
            System.err.println("Invalid input number");
            System.exit(1);
        }
        return num;
    }
}
