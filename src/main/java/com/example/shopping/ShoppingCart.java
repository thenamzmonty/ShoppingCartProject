package com.example.shopping;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {

    public static double calculateTotal(List<String> items) {
        Map<String, Integer> itemCounts = new HashMap<String, Integer>();
        for (String item : items) {
            if (itemCounts.containsKey(item)) {
                itemCounts.put(item, itemCounts.get(item) + 1);
            } else {
                itemCounts.put(item, 1);
            }
        }

        double total = 0.0;

        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();

            if (item.equals("Apple")) {
                total += count * 0.35;
            } else if (item.equals("Banana")) {
                total += count * 0.20;
            } else if (item.equals("Melon")) {
                total += (count / 2 + count % 2) * 0.50; // Buy One Get One Free
            } else if (item.equals("Lime")) {
                total += ((count / 3) * 2 + count % 3) * 0.15; // Three for Two
            } else {
                throw new IllegalArgumentException("Unknown item: " + item);
            }
        }

        return total;
    }
}
