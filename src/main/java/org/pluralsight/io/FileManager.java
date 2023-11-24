package org.pluralsight.io;

import java.io.*;

public class FileManager {
    private final String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public String readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath + fileName));
            String fileLine = null;
            while((fileLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(fileLine).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.printf("Oops could not read from File:%s",filePath);
        }

        return stringBuilder.toString();
    }

    public void writeToFile(String fileName, String fileContents) {
        File file = new File(filePath + fileName);

        try {
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(fileContents);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.printf("Oops could not write to File:%s",filePath);
        }
    }
}
