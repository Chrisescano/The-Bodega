package org.pluralsight.display;

import org.pluralsight.io.FileManager;
import org.pluralsight.util.TerminalFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private final String name, phone, address1, address2;
    private StringBuilder receiptBuilder;
    private final TerminalFormat format;
    private final LocalDateTime timeStamp;
    private final DateTimeFormatter receiptFormat, fileFormat;

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        System.out.println(receipt);
    }

    public Receipt() {
        /*----Store Information----*/
        FileManager store = new FileManager("");
        format = new TerminalFormat();
        timeStamp = LocalDateTime.now();
        receiptFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        fileFormat = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"); //remove ss for testing purposes

        String storeFile = store.readFromFile("storeInformation.csv");
        String[] storeInformation = storeFile.split("\n");

        name = storeInformation[0];
        phone = storeInformation[1];
        address1 = storeInformation[2];
        address2 = storeInformation[3];

        buildReceiptHeader();
    }

    public void buildReceiptHeader() {
        receiptBuilder = new StringBuilder();

        receiptBuilder.append(format.divider()).append("\n");
        receiptBuilder.append(format.tableRow(name, "center")).append("\n");
        receiptBuilder.append(format.divider()).append("\n");
        receiptBuilder.append(format.tableRow("phone " + phone, "center")).append("\n");
        receiptBuilder.append(format.tableRow(address1, "center")).append("\n");
        receiptBuilder.append(format.tableRow(address2, "center")).append("\n");
        receiptBuilder.append(format.tableRow(timeStamp.format(receiptFormat), "center")).append("\n");
        receiptBuilder.append(format.divider()).append("\n");
        receiptBuilder.append(format.tableRow("QTY ITEM","PRICE", "between")).append("\n");
        receiptBuilder.append(format.tableRow("--- ----", "-----", "between")).append("\n");
    }

    public void addLine(String quantity, String item, String price) {
        receiptBuilder.append(format.tableRow(
                " ".repeat(3 - quantity.length()) + quantity + " " + item,
                price, "between")).append("\n");
    }

    public void addLine(String item, String price) {
        receiptBuilder.append(format.tableRow("    " + item, price, "between")).append("\n");
    }

    public void addDivider() {
        receiptBuilder.append(format.divider()).append("\n");
    }

    public void save() {
        FileManager fileManager = new FileManager("Receipts/");
        fileManager.writeToFile(timeStamp.format(fileFormat) + ".txt", receiptBuilder.toString());
    }

    /*-----Getter-----*/

    @Override
    public String toString() {
        return receiptBuilder.toString();
    }
}
