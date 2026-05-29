package com.pluralsight.pizzaLicious.service;

import com.pluralsight.pizzaLicious.model.order.Order;
import com.pluralsight.pizzaLicious.model.order.OrderItem;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ReceiptService {

    public void saveReceipt(Order order) {

        File file = new File("receipts");
        if (!file.exists()) {
            file.mkdir();
        }

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = LocalDateTime.now().format(fmt) + ".txt";
        String filePath = "receipts/" + fileName;

        try {
            PrintWriter writer = new PrintWriter(filePath);

            writer.println("==========================================");
            writer.println(" (   (       )   )        (    (         (       )        (     \n" +
                    " )\\ ))\\ ) ( /(( /(  (     )\\ ) )\\ )  (   )\\ ) ( /(        )\\ )  \n" +
                    "(()/(()/( )\\())\\()) )\\   (()/((()/(  )\\ (()/( )\\())    ( (()/(  \n" +
                    " /(_))(_)|(_)((_)((((_)(  /(_))/(_)|((_) /(_)|(_)\\     )\\ /(_)) \n" +
                    "(_))(_))  _((_)((_)\\ _ )\\(_)) (_)) )\\___(_))   ((_) _ ((_|_))   \n" +
                    "| _ \\_ _||_  /_  /(_)_\\(_) |  |_ _((/ __|_ _| / _ \\| | | / __|  \n" +
                    "|  _/| |  / / / /  / _ \\ | |__ | | | (__ | | | (_) | |_| \\__ \\  \n" +
                    "|_| |___|/___/___|/_/ \\_\\|____|___| \\___|___| \\___/ \\___/|___/  \n" +
                    "                                                                " );
            writer.println("          Thank you for your order!");
            writer.println("==========================================");
            writer.println("Date/Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss")));
            writer.println("------------------------------------------");

            List<OrderItem> items = order.getItems();
            for (int i = items.size() - 1; i >= 0; i--) {
                OrderItem item = items.get(i);
                writer.printf("%-32s $%5.2f%n", item.getName(), item.calculatePrice());
            }

            writer.println("------------------------------------------");
            writer.printf("%-32s $%5.2f%n", "TOTAL", order.calculateTotal());
            writer.println("==========================================");

            writer.close();

            System.out.println("Receipt saved: " + filePath);

        } catch (Exception e) {
            System.out.println("Could not save receipt: " + e.getMessage());
        }
    }
}