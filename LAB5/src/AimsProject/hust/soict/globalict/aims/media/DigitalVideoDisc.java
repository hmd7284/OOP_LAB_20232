package AimsProject.hust.soict.globalict.aims.media;

import AimsProject.hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        super(id, title, category, director, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    public String toString() {
        return "DVD - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }

    public StringBuffer play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());

            StringBuffer information = new StringBuffer();
            information.append("Playing DVD: ").append(this.getTitle()).append("\n").append("DVD length: ").append(this.getLength());
            return information;
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive. This DVD can't be played");
        }
    }
}