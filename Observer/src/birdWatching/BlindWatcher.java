package birdWatching;

import java.beans.PropertyChangeEvent;

public class BlindWatcher {

    public BlindWatcher(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("sings a song", this::reactToSing);
        subject.addPropertyChangeListener("flashes its wings", this::reactToFlash);
    }

    private void reactToFlash(PropertyChangeEvent event) {
        System.out.println("Blind watcher says : Hello darkness my old friend !!!!");
    }

    private void reactToSing(PropertyChangeEvent event) {
        System.out.println("Blind watcher says : Oh! How sweet voice !!!!");
    }

}
