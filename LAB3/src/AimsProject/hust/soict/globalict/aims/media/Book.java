package AimsProject.hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author " + authorName + " is already associated with the book.");
        } else {
            authors.add(authorName);
            System.out.println("Author " + authorName + " has been added to the book.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " has been removed from the book.");
        } else {
            System.out.println("Author " + authorName + " is not associated with the book.");
        }
    }
    public String toString() {
        return "BOOK - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getAuthors() + ": " + this.getCost() + " $";
    }
}