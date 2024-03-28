package AimsProject;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final List<DigitalVideoDisc> itemsOrdered;
    private int qtyOrdered;

    public Cart() {
        qtyOrdered = 0;
        itemsOrdered = new ArrayList<>(MAX_NUMBERS_ORDERED);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc != null) {
            if (qtyOrdered > MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
            } else {
                qtyOrdered++;
                itemsOrdered.add(disc);
                System.out.println("The disc has been added");
            }
        } else {
            System.out.println("Invalid disk");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The cart is already empty");
            return;
        }
        int flag = 0;
        if (itemsOrdered.contains(disc)) {
            flag = 1;
            itemsOrdered.remove(disc);
        }
        if (flag == 0) {
            System.out.println("The disc is not in your cart");
        } else {
            System.out.println("The item has been removed");
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (DigitalVideoDisc item : itemsOrdered) {
            if (item != null) {
                totalCost += item.getCost();
            }
        }
        return totalCost;
    }
}