find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java avaj.launcher.Weather.Simulator avaj/launcher/scenario.txt
