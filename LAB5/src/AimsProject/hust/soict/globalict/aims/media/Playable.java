package AimsProject.hust.soict.globalict.aims.media;

import AimsProject.hust.soict.globalict.aims.exception.PlayerException;

public interface Playable {
    StringBuffer play() throws PlayerException;
}