package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel implements ActionListener {
    private final Media media;
    private JButton playButton;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            playButton = new JButton("Play");
            container.add(playButton);
            playButton.addActionListener(this);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            StringBuilder output = new StringBuilder();
            if (this.media instanceof DigitalVideoDisc) {
                output = new StringBuilder("Playing DVD: " + this.media.getTitle() + "\n" + "Length: " + ((DigitalVideoDisc) this.media).getLength());
            } else if (this.media instanceof CompactDisc) {
                output = new StringBuilder("Playing CD: " + this.media.getTitle() + "\n");
                for (Track track : ((CompactDisc) this.media).getTracks()) {
                    output.append("Playing track: ").append(track.getTitle()).append(". Track length: ").append(track.getLength()).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, output.toString(), "PLAYING", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}