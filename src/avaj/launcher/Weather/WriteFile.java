package avaj.launcher.Weather;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private static WriteFile writefile = null;
    private static BufferedWriter bufferedWriter = null;


    private WriteFile() {
    }

    public static WriteFile getWriteFile() {
        if (writefile == null) {
            try {
                File file;
                FileWriter fileWriter;
                writefile = new WriteFile();
                file = new File("stats.txt");
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
            return writefile;
    }

    public void writeToFile(String str) {
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            if ( bufferedWriter != null)
                bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("error trying to close the bufferWriter  " + e);
        }
    }
}
