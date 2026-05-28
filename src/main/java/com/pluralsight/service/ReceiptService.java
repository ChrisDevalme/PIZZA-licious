package com.pluralsight.service;

import com.pluralsight.model.Order;
import com.pluralsight.model.OrderItem;

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
            writer.println("        P I Z Z A - L I C I O U S");
            writer.println("          Thank you for your order!");
            writer.println("==========================================");
            writer.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss")));
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