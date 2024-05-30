package AimsProject.hust.soict.globalict.aims.media.comparator;

import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        try {
            float costDifference = m1.getCost() - m2.getCost();
            if (costDifference > 0) {
                return 1;
            } else if (costDifference < 0) {
                return -1;
            }
            return m1.getTitle().compareTo(m2.getTitle());
        } catch (NullPointerException e) {
            return -1;
        }
    }
}