package AimsProject.hust.soict.globalict.aims.media;

public class Track implements Playable {
    private final String title;
    private int length;

    public Track(String title) {
        this.title = title;
    }

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

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("This track can't be played");
        }
    }

    public String toString() {
        return this.getTitle() + ", " + this.getLength();
    }
}