package AimsProject.hust.soict.globalict.aims.media.comparator;

import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        String title1 = m1.getTitle();
        String title2 = m2.getTitle();
        int cmp = title1.compareTo(title2);
        if (cmp != 0) {
            return cmp;
        }
        Float cost1 = m1.getCost();
        Float cost2 = m2.getCost();
        return cost1.compareTo(cost2);
    }
}