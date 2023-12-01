package org.pluralsight.shop;

import org.pluralsight.io.FileManager;
import org.pluralsight.util.TerminalFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private String name, phone, address1, address2;
    private final StringBuilder receiptHeader;
    private final StringBuilder receiptBody;
    private final TerminalFormat format;
    private LocalDateTime timeStamp;
    private final DateTimeFormatter receiptFormat;
    private final DateTimeFormatter fileFormat;

    public Receipt() {
        receiptHeader = new StringBuilder();
        receiptBody = new StringBuilder();
        format = new TerminalFormat();
        receiptFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        fileFormat = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"); //remove ss for testing purposes

        receiptBody.append(format.divider()).append("\n");
        receiptBody.append(format.tableRow("ITEM","PRICE", "between")).append("\n");
        receiptBody.append(format.tableRow("----", "-----", "between")).append("\n");
    }

    public void appendToReceipt(String contents) {
        receiptBody.append(contents);
    }

    public void save() {
        init();
        buildReceiptHeader();

        FileManager fileManager = new FileManager("Receipts/");
        String receipt = receiptHeader + receiptBody.toString();
        fileManager.writeToFile(timeStamp.format(fileFormat) + ".txt", receipt);
    }

    /*-----Private Methods-----*/
    private void init() {
        FileManager store = new FileManager("resource/");
        timeStamp = LocalDateTime.now();

        String storeFile = store.readFromFile("storeInformation.csv");
        String[] storeInformation = storeFile.split("\n");

        name = storeInformation[0];
        phone = storeInformation[1];
        address1 = storeInformation[2];
        address2 = storeInformation[3];
    }

    private void buildReceiptHeader() {
        receiptHeader.append(format.divider()).append("\n");
        receiptHeader.append(format.tableRow(name, "center")).append("\n");
        receiptHeader.append(format.divider()).append("\n");
        receiptHeader.append(format.tableRow("phone " + phone, "center")).append("\n");
        receiptHeader.append(format.tableRow(address1, "center")).append("\n");
        receiptHeader.append(format.tableRow(address2, "center")).append("\n");
        receiptHeader.append(format.tableRow(timeStamp.format(receiptFormat), "center")).append("\n");
    }

    /*-----Getter-----*/

    @Override
    public String toString() {
        return receiptBody.toString();
    }
}
