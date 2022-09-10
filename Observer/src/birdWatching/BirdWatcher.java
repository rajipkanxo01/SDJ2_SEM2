package birdWatching;

import java.beans.PropertyChangeEvent;

public class BirdWatcher {

    public BirdWatcher(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("flashes its wings", this::reactToFlash);
        subject.addPropertyChangeListener("whistles", this::reactToWhistle);
        subject.addPropertyChangeListener("sings a song", this::reactToSing);
    }

    public void reactToFlash(PropertyChangeEvent event) {
        System.out.println("Bird watcher says : Would you look at that!!!!!!!!! ");
    }

    public void reactToWhistle(PropertyChangeEvent event) {
        System.out.println("Bird watcher says : How nice!!!!!! ");
    }

    public void reactToSing(PropertyChangeEvent event) {
        System.out.println("Bird watcher says : Ooh!!!!!!!! ");
    }
}
