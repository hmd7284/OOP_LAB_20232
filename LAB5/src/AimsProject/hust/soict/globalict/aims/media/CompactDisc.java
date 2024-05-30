package AimsProject.hust.soict.globalict.aims.media;

import AimsProject.hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private final ArrayList<Track> tracks = new ArrayList<>();
    private String artist;

    public CompactDisc(int id, String title) {
        super(id, title);
    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("This track is already in the CD");
        } else {
            tracks.add(track);
            System.out.println("The track has been added to the CD");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("This track has been removed from the CD");
        } else {
            System.out.println("The track is not in the CD");
        }
    }

    public int getLength() {
        int discLength = 0;
        for (Track track : tracks) {
            discLength += track.getLength();
        }
        return discLength;
    }

    public String toString() {
        return "CD - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + ": " + this.getCost() + " $\n" + "Track list:\n" + this.tracks;
    }

    public StringBuffer play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());

            StringBuffer information = new StringBuffer();
            information.append("Playing CD: ").append(this.getTitle()).append("\n").append("CD length: ").append(this.getLength()).append("\n");

            for (Track t : tracks) {
                try {
                    StringBuffer trackInfo = t.play();
                    information.append(trackInfo).append("\n");
                } catch (PlayerException e) {
                    throw e;
                }
            }
            return information;
        } else {
            throw new PlayerException("ERROR: CD length is non-positive! This CD can't be played");
        }
    }
}