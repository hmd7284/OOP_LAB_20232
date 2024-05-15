package AimsProject.hust.soict.globalict.aims.store;

import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public ArrayList<Media> itemsInStore = new ArrayList<>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media) {
        if (media != null) {
            if (itemsInStore.contains(media)) {
                System.out.println("The item is already in the store");
            } else {
                itemsInStore.add(media);
                System.out.println("The item has been added to the store");
            }
        } else {
            System.out.println("Invalid item");
        }
    }

    public void removeMedia(Media media) {
        if (media != null) {
            if (itemsInStore.contains(media)) {
                itemsInStore.remove(media);
                System.out.println("The item has been removed from the store");
            } else {
                System.out.println("The item is not in the store");
            }
        } else {
            System.out.println("Invalid item");
        }
    }

    public void printStore() {
        System.out.println("********************************STORE********************************");
        System.out.println("Items in store:");
        for (Media item : itemsInStore) {
            System.out.println(item.toString());
        }
        System.out.println("*********************************************************************");
    }

    public Media searchStore(String title) {
        for (Media item : itemsInStore) {
            if (item.isMatch(title)) {
                return item;
            }
        }
        return null;
    }
}