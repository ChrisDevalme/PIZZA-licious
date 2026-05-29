package com.pluralsight.pizzaLicious.model.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private LocalDateTime orderDateTime;

    public Order() {
        items = new ArrayList<>();
        orderDateTime = LocalDateTime.now();
    }

    public void addItem(OrderItem orderItem){
        items.add(orderItem);
    }

    public void removeItem(int index) {
        if(index > 0 && index < items.size()) {
            System.out.println("Removing: " + items.get(index).toString() + " from order.");
            items.remove(index);
        }
    }

    public List<OrderItem> getItems() { return items; }

    public double calculateTotal(){
        double total = 0;
        for (OrderItem item : items) {
            total += item.calculatePrice();
        }
        return total;
    }

}


