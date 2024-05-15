package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        JPanel directorPanel = super.createSubPanel("Director");
        JPanel lengthPanel = super.createSubPanel("Length");

        super.centerPanel.add(directorPanel, BorderLayout.CENTER);
        super.centerPanel.add(lengthPanel, BorderLayout.CENTER);

        btnAdd.addActionListener(new btnAddListener());
        super.setTitle("Add DVD");
    }

    private class btnAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String title = null;
            String category = null;
            float cost = 0;
            String director = null;
            int length = 0;
            for (JTextField tf : tfs) {
                if (tf.getName().equals("ID")) {
                    id = Integer.parseInt(tf.getText());
                } else if (tf.getName().equals("Title")) {
                    title = tf.getText();
                } else if (tf.getName().equals("Category")) {
                    category = tf.getText();
                } else if (tf.getName().equals("Director")) {
                    director = tf.getText();
                } else if (tf.getName().equals("Length")) {
                    length = Integer.parseInt(tf.getText());
                } else if (tf.getName().equals("Cost")) {
                    cost = Float.parseFloat(tf.getText());
                }
            }
            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
            store.addMedia(dvd);
        }
    }
}