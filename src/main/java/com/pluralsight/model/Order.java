package com.pluralsight.model;

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

    public List<OrderItem> getItems() { return items; }

    public double calculateTotal(){
        return 0;
    }

}


