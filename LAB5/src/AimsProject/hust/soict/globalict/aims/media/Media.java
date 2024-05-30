package AimsProject.hust.soict.globalict.aims.media;

import AimsProject.hust.soict.globalict.aims.media.comparator.MediaComparatorByCostTitle;
import AimsProject.hust.soict.globalict.aims.media.comparator.MediaComparatorByTitleCost;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }

    public boolean equals(Object o) {
        try {
            return this.title.equals(((Media) o).getTitle()) && this.cost == ((Media) o).getCost();
        } catch (NullPointerException | ClassCastException e) {
            return false;
        }
    }

    public int compareTo(Media item) {
        try {
            int titleDifference = this.getTitle().compareTo(item.getTitle());
            if (titleDifference != 0) {
                return titleDifference;
            } else {
                return this.getCategory().compareTo(item.getCategory());
            }
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public boolean filterProperty(String filter, String type) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else {
            if (type.equals("title")) {
                return this.getTitle().toLowerCase().indexOf(filter.toLowerCase()) != -1;
            } else if (type.equals("id")) {
                return Integer.toString(this.getId()).toLowerCase().indexOf(filter.toLowerCase()) != -1;
            }
        }
        return false;
    }
}