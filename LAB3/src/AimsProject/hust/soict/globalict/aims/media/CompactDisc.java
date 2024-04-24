package AimsProject.hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private final ArrayList<Track> tracks = new ArrayList<>();
    private String artist;

    public CompactDisc(int id, String title) {
        super(id, title);
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, director, length, cost);
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

    @Override
    public void play() {
        if (tracks.isEmpty()) {
            System.out.println("This track can't be played");
        } else {
            for (Track track : tracks) {
                System.out.print("Track " + tracks.indexOf(track) + 1 + ": ");
                track.play();
            }
        }
    }

}