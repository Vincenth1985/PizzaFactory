package be.intecbrussel.services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataWriterAndReader {

    Path pt = Paths.get("File.txt");


    public void pizzaManagementLog(String message) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pt.toFile(),true))) {

            if (pt.toFile().isFile()) {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();

        } catch (
                IOException IOE) {
            IOE.printStackTrace();
        }


    }
}
