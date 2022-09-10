package soccerMatch;

import java.beans.PropertyChangeEvent;

public class Refree {

    public Refree(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("DreamTeamTackles", this::reactToDreamTeamTackle);
        subject.addPropertyChangeListener("OldBoysTackles", this::reactToOldBoysTackle);
    }

    private void reactToOldBoysTackle(PropertyChangeEvent event) {
        System.out.println("Referee gives Old Boys a yellow card for a rough tackle");
    }

    private void reactToDreamTeamTackle(PropertyChangeEvent event) {
        System.out.println("Referee gives DreamTeam a yellow card for a rough tackle");
    }
}
