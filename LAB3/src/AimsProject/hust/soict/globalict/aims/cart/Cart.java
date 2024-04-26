package AimsProject.hust.soict.globalict.aims.cart;

import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static int MAX_NUMBERS_ORDERED = 20;
    private final ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media, Store store) {
        if (store.itemsInStore.contains(media)) {
            if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
            } else {
                itemsOrdered.add(media);
                System.out.println("The item has been added to the cart");
            }
        } else {
            System.out.println("This media item is not available in store");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is already empty");
        } else {
            if (itemsOrdered.contains(media)) {
                itemsOrdered.remove(media);
                System.out.println("The media item has been removed from the cart");
            } else {
                System.out.println("The media item is not in the cart");
            }
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media item : itemsOrdered) {
            if (item != null) {
                totalCost += item.getCost();
            }
        }
        return totalCost;
    }

    public void printCart() {
        System.out.println("********************************CART********************************");
        System.out.println("Ordered Items:");
        for (Media item : itemsOrdered) {
            System.out.println(item.toString());

        }
        System.out.println("Total cost: " + this.totalCost() + " $");
        System.out.println("********************************************************************");
    }

    public Media searchCart(String title) {
        for (Media item : itemsOrdered) {
            if (item.isMatch(title)) {
                return item;
            }
        }
        return null;
    }

    public Media searchCart(int id) {
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortCartByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public int sizeCart() {
        return itemsOrdered.size();
    }
}