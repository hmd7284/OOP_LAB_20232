package AimsProject.hust.soict.globalict.aims;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.exception.LimitExceededException;
import AimsProject.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.hust.soict.globalict.aims.media.*;
import AimsProject.hust.soict.globalict.aims.store.Store;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Aims {

    public static void defaultStore(Store store) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
        ArrayList<String> authors = new ArrayList<>();
        authors.add("HMD");
        Book book1 = new Book(4, "Sherlock Holmes", "Detective", 100.0f, authors);
        CompactDisc cd1 = new CompactDisc(5, "ABC", "DEF", 100.0f, "Zero");
        Track track1 = new Track("Baby Blue", 100);
        Track track2 = new Track("Free Bird", 100);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(cd1);
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("________________________________");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Store options:");
        System.out.println("________________________________");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void updateStoreMenu() {
        System.out.println("Update Store options:");
        System.out.println("________________________________");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void addMediaMenu() {
        System.out.println("Media options:");
        System.out.println("________________________________");
        System.out.println("1. Add a CD to store");
        System.out.println("2. Add a DVD to store");
        System.out.println("3. Add a book to store");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Media Details options:");
        System.out.println("________________________________");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Cart options:");
        System.out.println("________________________________");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void main(String[] args) throws PlayerException {
        Random rand = new Random();
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scn = new Scanner(System.in);
        String title;
        int mainOption = 1;
        int storeOption = 1;
        int mediaOption = 1;
        int cartOption = 1;
        int filterOption = 1;
        int sortOption = 1;
        int updateStoreOption = 1;
        int addMediaOption = 1;
        Media storeMedia, cartMedia;
        defaultStore(store);
        do {
            showMenu();
            try {
                mainOption = scn.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid option. Please enter a valid integer");
                scn.next();
            }
            switch (mainOption) {
                case 1:
                    store.printStore();
                    do {
                        storeMenu();
                        try {
                            storeOption = scn.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid option. Please enter a valid integer");
                            scn.next();
                        }
                        switch (storeOption) {
                            case 1:
                                scn.nextLine();
                                do {
                                    System.out.print("Please enter the title of the media you want to see: ");
                                    title = scn.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("This media item is not in store");
                                    }
                                } while (storeMedia == null);
                                System.out.println(storeMedia);
                                do {
                                    mediaDetailsMenu();
                                    try {
                                        mediaOption = scn.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid option. Please enter a valid integer");
                                        scn.next();
                                    }
                                    switch (mediaOption) {
                                        case 0:
                                            storeMenu();
                                            break;
                                        case 1:
                                            try {
                                                cart.addMedia(storeMedia, store);
                                            } catch (LimitExceededException e) {
                                                e.printStackTrace();
                                                System.out.println(e.getMessage());
                                            }
                                            System.out.println("Updated cart:");
                                            cart.printCart();
                                            break;
                                        case 2:
                                            store.playMedia(title);
                                            break;
                                        default:
                                            System.out.println("Invalid option! Please choose between 0, 1 and 2");
                                            break;
                                    }
                                } while (mediaOption != 0);
                                break;
                            case 2:
                                scn.nextLine();
                                store.printStore();
                                do {
                                    System.out.print("Please enter the title of the media you want to add to cart: ");
                                    title = scn.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("This media item is not in the store");
                                    }
                                } while (storeMedia == null);
                                try {
                                    cart.addMedia(storeMedia, store);
                                } catch (LimitExceededException e) {
                                    e.printStackTrace();
                                    System.out.println(e.getMessage());
                                }
                                System.out.println("The cart now contains " + cart.sizeCart() + " media items:");
                                cart.printCart();
                                break;
                            case 3:
                                scn.nextLine();
                                store.printStore();
                                do {
                                    System.out.print("Please enter the title of the media you want to play(must be DVD or CD): ");
                                    title = scn.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("This media item is not in the store");
                                    }
                                } while (storeMedia == null);
                                store.playMedia(title);
                                break;
                            case 4:
                                do {
                                    cart.printCart();
                                    cartMenu();
                                    try {
                                        cartOption = scn.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid option. Please enter a valid integer");
                                        scn.next();
                                    }
                                    switch (cartOption) {
                                        case 1:
                                            cart.printCart();
                                            do {
                                                try {
                                                    System.out.print("Please enter 1 to filter by id or 2 to filter by title: ");
                                                    filterOption = scn.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Invalid option. Please enter a valid integer");
                                                    scn.next();
                                                }
                                                switch (filterOption) {
                                                    case 1:
                                                        int idFilter = 1;
                                                        do {
                                                            try {
                                                                System.out.print("Please enter id: ");
                                                                idFilter = scn.nextInt();
                                                                if (idFilter < 0) {
                                                                    System.out.println("Invalid input. ID must be >= 0");
                                                                }
                                                            } catch (InputMismatchException e) {
                                                                System.out.println("Invalid input. Please enter a valid integer");
                                                                scn.next();
                                                            }
                                                            cartMedia = cart.searchCart(idFilter);
                                                            if (cartMedia != null) {
                                                                System.out.println("Media item found:");
                                                                System.out.println(cartMedia);
                                                            } else {
                                                                System.out.println("There is no media item in the cart that has given id");
                                                            }
                                                        } while (idFilter < 0);
                                                        break;
                                                    case 2:
                                                        scn.nextLine();
                                                        String titleFilter;
                                                        System.out.print("Please enter title: ");
                                                        titleFilter = scn.nextLine();
                                                        cartMedia = cart.searchCart(titleFilter);
                                                        if (cartMedia != null) {
                                                            System.out.println("Media item found:");
                                                            System.out.println(cartMedia);
                                                        } else {
                                                            System.out.println("There is no media item in the cart that has given title");
                                                        }
                                                        break;
                                                    default:
                                                        System.out.println("Invalid option. Please choose between 1 or 2");
                                                        break;
                                                }
                                            } while (filterOption != 1 && filterOption != 2);
                                            break;
                                        case 2:
                                            cart.printCart();
                                            do {
                                                try {
                                                    System.out.print("Please enter 1 to sort by title or 2 to sort by cost: ");
                                                    sortOption = scn.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Invalid option. Please enter a valid integer");
                                                    scn.next();
                                                }
                                                switch (sortOption) {
                                                    case 1:
                                                        cart.sortCartByTitle();
                                                        cart.printCart();
                                                        break;
                                                    case 2:
                                                        cart.sortCartByCost();
                                                        cart.printCart();
                                                        break;
                                                    default:
                                                        System.out.println("Invalid option. Please choose between 1 or 2");
                                                        break;
                                                }
                                            } while (sortOption != 1 && sortOption != 2);
                                            break;
                                        case 3:
                                            scn.nextLine();
                                            cart.printCart();
                                            do {
                                                System.out.print("Enter title of media you want to remove: ");
                                                title = scn.nextLine();
                                                cartMedia = cart.searchCart(title);
                                                if (cartMedia == null) {
                                                    System.out.println("The media item with given title is not in the cart");
                                                }
                                            } while (cartMedia == null);
                                            cart.removeMedia(cartMedia);
                                            System.out.println("Updated cart:");
                                            cart.printCart();
                                            break;
                                        case 4:
                                            scn.nextLine();
                                            cart.printCart();
                                            do {
                                                System.out.print("Enter title of media you want to play(must be CD or DVD): ");
                                                title = scn.nextLine();
                                                cartMedia = cart.searchCart(title);
                                                if (cartMedia == null) {
                                                    System.out.println("The media item is not in the cart");
                                                }
                                            } while (cartMedia == null);
                                            cart.playMedia(title);
                                            break;
                                        case 5:

                                            if (cart.sizeCart() > 0) {
                                                System.out.println("An order is created");
                                                cart = new Cart();
                                            } else {
                                                System.out.println("The cart is empty");
                                            }
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid option. Please choose between 0,1,2,3,4 and 5");
                                            break;
                                    }
                                } while (cartOption != 0);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid option. Please choose between 0,1,2,3 and 4");
                                break;
                        }
                    } while (storeOption != 0);
                    break;
                case 2:
                    store.printStore();
                    do {
                        updateStoreMenu();
                        try {
                            updateStoreOption = scn.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid option. Please enter a valid integer");
                            scn.next();
                        }
                        switch (updateStoreOption) {
                            case 1:
                                scn.nextLine();
                                store.printStore();
                                System.out.println("Please provide the details of the media you want to add");
                                do {
                                    System.out.print("Title: ");
                                    title = scn.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia != null) {
                                        System.out.println("Media item with same title already exists in store");
                                    }
                                } while (storeMedia != null);
                                System.out.print("Category: ");
                                String category;
                                category = scn.nextLine();
                                float cost = 0.0f;
                                do {
                                    try {
                                        System.out.print("Cost: ");
                                        cost = scn.nextFloat();
                                        if (cost < 0) {
                                            System.out.println("Invalid input. Cost must be >= 0");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a valid floating point number");
                                        scn.next();
                                    }
                                } while (cost < 0);
                                int id = rand.nextInt(1000);
                                do {
                                    try {
                                        addMediaMenu();
                                        addMediaOption = scn.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid option. Please enter a valid integer");
                                        scn.next();
                                    }
                                    switch (addMediaOption) {
                                        case 1:
                                            scn.nextLine();
                                            System.out.print("Artist name: ");
                                            String artist;
                                            artist = scn.nextLine();
                                            CompactDisc cd = new CompactDisc(id, title, category, cost, artist);
                                            int trackCount = 0;
                                            do {
                                                try {
                                                    System.out.print("Enter number of tracks(must be > 0): ");
                                                    trackCount = scn.nextInt();
                                                    if (trackCount <= 0) {
                                                        System.out.println("Invalid input. The number of tracks must be > 0");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Invalid input. Please enter a valid integer");
                                                    scn.next();
                                                }
                                            } while (trackCount <= 0);
                                            scn.nextLine();
                                            for (int i = 0; i < trackCount; i++) {
                                                System.out.print("Enter track title: ");
                                                title = scn.nextLine();
                                                int length = 0;
                                                do {
                                                    try {
                                                        System.out.print("Enter track length(must be >= 0): ");
                                                        length = scn.nextInt();
                                                        if (length < 0) {
                                                            System.out.println("Invalid input. Track length must be >= 0");
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("Invalid input. Please enter a valid integer");
                                                        scn.next();
                                                    }
                                                } while (length < 0);
                                                Track track = new Track(title, length);
                                                cd.addTrack(track);
                                            }
                                            store.addMedia(cd);
                                            System.out.println("Updated store");
                                            store.printStore();
                                            break;
                                        case 2:
                                            scn.nextLine();
                                            String director;
                                            System.out.print("Enter director name: ");
                                            director = scn.nextLine();
                                            int length = 0;
                                            do {
                                                try {
                                                    System.out.print("Enter length of DVD(must be >= 0): ");
                                                    length = scn.nextInt();
                                                    if (length < 0) {
                                                        System.out.println("Invalid input. Length of DVD must be >= 0");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Invalid input. Please enter a valid integer");
                                                    scn.next();
                                                }
                                            } while (length < 0);
                                            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
                                            store.addMedia(dvd);
                                            System.out.println("Updated store");
                                            store.printStore();
                                            break;
                                        case 3:
                                            Book book = new Book(id, title, category, cost);
                                            int authorCount = 0;
                                            String author;
                                            do {
                                                try {
                                                    System.out.print("Enter number of authors(must be > 0): ");
                                                    authorCount = scn.nextInt();
                                                    if (authorCount <= 0) {
                                                        System.out.println("Invalid input. Number of authors must be > 0");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Invalid input. Please enter a valid integer");
                                                    scn.next();
                                                }
                                            } while (authorCount <= 0);
                                            scn.nextLine();
                                            for (int i = 0; i < authorCount; i++) {
                                                System.out.print("Enter author name: ");
                                                author = scn.nextLine();
                                                book.addAuthor(author);
                                            }
                                            store.addMedia(book);
                                            System.out.println("Updated store");
                                            store.printStore();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid option. Please choose number between 0,1,2 and 3");
                                            break;
                                    }
                                } while (addMediaOption != 0);
                                System.out.println("Updated store:");
                                store.printStore();
                                break;
                            case 2:
                                scn.nextLine();
                                store.printStore();
                                do {
                                    System.out.print("Enter title of the media you want to remove: ");
                                    title = scn.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("The media item is not in store");
                                    }
                                } while (storeMedia == null);
                                store.removeMedia(storeMedia);
                                System.out.println("Updated store:");
                                store.printStore();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid option. Please choose number between 0,1 and 2");
                                break;
                        }
                    } while (updateStoreOption != 0);
                    break;
                case 3:
                    do {
                        cart.printCart();
                        cartMenu();
                        try {
                            cartOption = scn.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid option. Please enter a valid integer");
                            scn.next();
                        }
                        switch (cartOption) {
                            case 1:
                                cart.printCart();
                                do {
                                    try {
                                        System.out.print("Please enter 1 to filter by id or 2 to filter by title: ");
                                        filterOption = scn.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid option. Please enter a valid integer");
                                        scn.next();
                                    }
                                    switch (filterOption) {
                                        case 1:
                                            int idFilter = 1;
                                            do {
                                                try {
                                                    System.out.print("Please enter id: ");
                                                    idFilter = scn.nextInt();
                                                    if (idFilter < 0) {
                                                        System.out.println("Invalid input. ID must be >= 0");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Invalid input. Please enter a valid integer");
                                                    scn.next();
                                                }
                                                cartMedia = cart.searchCart(idFilter);
                                                if (cartMedia != null) {
                                                    System.out.println("Media item found:");
                                                    System.out.println(cartMedia);
                                                } else {
                                                    System.out.println("There is no media item in the cart that has given id");
                                                }
                                            } while (idFilter < 0);
                                            break;
                                        case 2:
                                            scn.nextLine();
                                            String titleFilter;
                                            System.out.print("Please enter title: ");
                                            titleFilter = scn.nextLine();
                                            cartMedia = cart.searchCart(titleFilter);
                                            if (cartMedia != null) {
                                                System.out.println("Media item found:");
                                                System.out.println(cartMedia);
                                            } else {
                                                System.out.println("There is no media item in the cart that has given title");
                                            }
                                            break;
                                        default:
                                            System.out.println("Invalid option. Please choose between 1 or 2");
                                            break;
                                    }
                                } while (filterOption != 1 && filterOption != 2);
                                break;
                            case 2:
                                cart.printCart();
                                do {
                                    try {
                                        System.out.print("Please enter 1 to sort by title or 2 to sort by cost: ");
                                        sortOption = scn.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid option. Please enter a valid integer");
                                        scn.next();
                                    }
                                    switch (sortOption) {
                                        case 1:
                                            cart.sortCartByTitle();
                                            cart.printCart();
                                            break;
                                        case 2:
                                            cart.sortCartByCost();
                                            cart.printCart();
                                            break;
                                        default:
                                            System.out.println("Invalid option. Please choose between 1 or 2");
                                            break;
                                    }
                                } while (sortOption != 1 && sortOption != 2);
                                break;
                            case 3:
                                scn.nextLine();
                                cart.printCart();
                                do {
                                    System.out.print("Enter title of media you want to remove: ");
                                    title = scn.nextLine();
                                    cartMedia = cart.searchCart(title);
                                    if (cartMedia == null) {
                                        System.out.println("The media item with given title is not in the cart");
                                    }
                                } while (cartMedia == null);
                                cart.removeMedia(cartMedia);
                                System.out.println("Updated cart:");
                                cart.printCart();
                                break;
                            case 4:
                                scn.nextLine();
                                cart.printCart();
                                do {
                                    System.out.print("Enter title of media you want to play(must be CD or DVD): ");
                                    title = scn.nextLine();
                                    cartMedia = cart.searchCart(title);
                                    if (cartMedia == null) {
                                        System.out.println("The media item is not in the cart");
                                    }
                                } while (cartMedia == null);
                                cart.playMedia(title);
                                break;
                            case 5:

                                if (cart.sizeCart() > 0) {
                                    System.out.println("An order is created");
                                    cart = new Cart();
                                } else {
                                    System.out.println("The cart is empty");
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid option. Please choose between 0,1,2,3,4 and 5");
                                break;
                        }
                    } while (cartOption != 0);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 0,1,2 and 3");
                    break;
            }
        } while (mainOption != 0);
        scn.close();
    }
}