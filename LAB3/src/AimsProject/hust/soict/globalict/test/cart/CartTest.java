package AimsProject.hust.soict.globalict.test.cart;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.Book;
import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

public class CartTest {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
        Book book1 = new Book(4, "HMD", "HMD", 100.0f);
        book1.addAuthor("Duc");
        book1.addAuthor("Kien");
        book1.addAuthor("Minh");
        book1.addAuthor("Dat");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        cart.addMedia(dvd1, store);
        cart.addMedia(dvd2, store);
        cart.addMedia(dvd3, store);
        cart.addMedia(book1, store);
        cart.addMedia(book1, store);
        System.out.println(cart.searchCart("Star Wars"));
        System.out.println(cart.searchCart(1));
        cart.sortCartByTitle();
        cart.printCart();
        cart.sortCartByCost();
        cart.printCart();
        cart.removeMedia(dvd2);
    }
}