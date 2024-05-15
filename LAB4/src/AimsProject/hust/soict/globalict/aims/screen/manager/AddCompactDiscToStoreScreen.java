package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.CompactDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        JPanel artistPanel = super.createSubPanel("Artist");

        super.centerPanel.add(artistPanel, BorderLayout.CENTER);

        btnAdd.addActionListener(new btnAddListener());
        super.setTitle("Add CD");
    }

    private class btnAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String title = null;
            String category = null;
            String artist = null;
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
                } else if (tf.getName().equals("Artist")) {
                    artist = tf.getText();
                }
            }
            CompactDisc cd = new CompactDisc(id, title, category, cost, artist);
            store.addMedia(cd);
        }
    }
}