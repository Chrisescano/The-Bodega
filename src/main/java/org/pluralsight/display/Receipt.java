package org.pluralsight.display;

import org.pluralsight.io.FileManager;
import org.pluralsight.util.TerminalFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private final String name;
    private final String phone;
    private final String address1;
    private final String address2;
    private final String timeStamp;
    private StringBuilder receiptBuilder;
    private TerminalFormat format;

    public Receipt() {
        /*----Store Information----*/
        FileManager fileManager = new FileManager("");
        format = new TerminalFormat();

        String file = fileManager.readFromFile("storeInformation.csv");
        String[] storeInformation = file.split("\n");

        name = storeInformation[0];
        phone = storeInformation[1];
        address1 = storeInformation[2];
        address2 = storeInformation[3];

        /*----Time Stamp Info----*/
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        timeStamp = LocalDateTime.now().format(dateTimeFormatter);

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
        receiptBuilder.append(format.divider()).append("\n");
        receiptBuilder.append(format.tableRow("QTY ITEM","PRICE", "between")).append("\n");
        receiptBuilder.append(format.tableRow("--- ----", "-----", "between")).append("\n");
    }

    public void addLine(String quantity, String item, String price) {
        StringBuilder builder = new StringBuilder(" ".repeat(3 - quantity.length()));
        builder.append(quantity).append(" ").append(item);
        receiptBuilder.append(format.tableRow(builder.toString(), price, "between")).append("\n");
    }

    public void addLine(String item, String price) {
        receiptBuilder.append(format.tableRow("    " + item, price, "between")).append("\n");
    }

    public void addDivider() {
        receiptBuilder.append(format.line()).append("\n");
    }

    /*-----Getter-----*/
    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return receiptBuilder.toString();
    }
}
