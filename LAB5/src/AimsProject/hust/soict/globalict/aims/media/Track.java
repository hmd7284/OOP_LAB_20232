package AimsProject.hust.soict.globalict.aims.media;

import AimsProject.hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return this.getTitle() + " - " + this.getLength();
    }

    @Override
    public boolean equals(Object o) {
        try {
            return this.title.equals(((Track) o).getTitle()) && this.length == ((Track) o).getLength();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public StringBuffer play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());

            StringBuffer info = new StringBuffer();
            info.append("Playing track: ").append(this.getTitle()).append("\n").append("Track length: ").append(this.getLength());
            return info;
        } else {
            throw new PlayerException("ERROR: Track length is non-positive! This track can't be played");
        }
    }
}