package org.pluralsight.display;

import org.pluralsight.io.FileManager;
import org.pluralsight.util.TerminalFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private String name;
    private String phone;
    private String address1;
    private String address2;
    private String timeStamp;
    private StringBuilder receiptBuilder;

    public Receipt() {
        /*----Store Information----*/
        FileManager fileManager = new FileManager("");
        String file = fileManager.readFromFile("storeInformation.csv");
        String[] storeInformation = file.split("\n");

        name = storeInformation[0];
        phone = storeInformation[1];
        address1 = storeInformation[2];
        address2 = storeInformation[3];

        /*----Time Stamp Info----*/
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        timeStamp = LocalDateTime.now().format(dateTimeFormatter);
    }

    public void buildReceipt() {
        receiptBuilder = new StringBuilder();
        TerminalFormat terminalFormat = new TerminalFormat();

        receiptBuilder.append(terminalFormat.centerAlign(name)).append("\n");
        receiptBuilder.append(terminalFormat.lineDivider()).append("\n");
        receiptBuilder.append(terminalFormat.centerAlign("phone " + phone)).append("\n");
        receiptBuilder.append(terminalFormat.centerAlign(address1)).append("\n");
        receiptBuilder.append(terminalFormat.centerAlign(address2)).append("\n");
        receiptBuilder.append(terminalFormat.lineDivider());
        System.out.println(receiptBuilder.toString());
    }

    /*-----Getter-----*/
    public String getTimeStamp() {
        return timeStamp;
    }
}
