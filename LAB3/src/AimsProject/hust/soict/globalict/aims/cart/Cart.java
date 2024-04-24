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
            System.out.println("Invalid item");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is already empty");
        } else {
            if (itemsOrdered.contains(media)) {
                itemsOrdered.remove(media);
                System.out.println("The item has been removed from the cart");
            } else {
                System.out.println("The item is not in the cart");
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
            System.out.println(itemsOrdered.indexOf(item) + 1 + ". " + item.toString());

        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("********************************************************************");
    }

    public void searchCartByTitle(String title) {
        int flag = 0;
        for (Media item : itemsOrdered) {
            if (item.isMatch(title)) {
                flag = 1;
                System.out.println(itemsOrdered.indexOf(item) + 1 + ". " + item);
            }
        }
        if (flag == 0) {
            System.out.println("There is no item that has given title");
        }
    }

    public void searchCartById(int id) {
        if (id < 0 || id > itemsOrdered.size()) {
            System.out.println("There is no item that has given id");
        } else if (itemsOrdered.get(id) != null) {
            System.out.println(id + 1 + ". " + itemsOrdered.get(id).toString());
        } else {
            System.out.println("There is no item that has given id");
        }
    }

    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortCartByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}