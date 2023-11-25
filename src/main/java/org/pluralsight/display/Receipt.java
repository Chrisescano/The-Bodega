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

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.buildReceipt();
    }

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
        TerminalFormat format = new TerminalFormat();

        receiptBuilder.append(format.divider()).append("\n");
        receiptBuilder.append(format.tableRow(name, "center")).append("\n");
        receiptBuilder.append(format.divider()).append("\n");
        receiptBuilder.append(format.tableRow("phone " + phone, "center")).append("\n");
        receiptBuilder.append(format.tableRow(address1, "center")).append("\n");
        receiptBuilder.append(format.tableRow(address2, "center")).append("\n");
        receiptBuilder.append(format.divider());
        System.out.println(receiptBuilder.toString());
    }

    /*-----Getter-----*/
    public String getTimeStamp() {
        return timeStamp;
    }
}
