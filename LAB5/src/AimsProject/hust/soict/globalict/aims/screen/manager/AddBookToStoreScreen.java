package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.Book;
import AimsProject.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
        btnAdd.addActionListener(new btnAddListener());
        super.setTitle("Add Book");
    }

    private class btnAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String title = null;
            String category = null;
            float cost = 0f;
            for (JTextField tf : tfs) {
                if (tf.getName().equals("ID")) {
                    id = Integer.parseInt(tf.getText());
                } else if (tf.getName().equals("Title")) {
                    title = tf.getText();
                } else if (tf.getName().equals("Category")) {
                    category = tf.getText();
                } else if (tf.getName().equals("Cost")) {
                    cost = Float.parseFloat(tf.getText());
                }
            }

            Book book = new Book(id, title, category, cost);
            store.addMedia(book);
        }
    }
}