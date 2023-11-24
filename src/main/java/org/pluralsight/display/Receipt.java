package org.pluralsight.display;

import org.pluralsight.io.FileManager;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private final String timeStamp;
    private FileManager storeFileManager;
    private FileManager orderFileManager;

    public Receipt() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        timeStamp = LocalDateTime.now().format(dateTimeFormatter);

        storeFileManager = new FileManager("");
        orderFileManager = new FileManager("Toppings/");
    }

    /*-----Getter-----*/
    public String getTimeStamp() {
        return timeStamp;
    }
}
