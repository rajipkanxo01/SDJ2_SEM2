package soccerMatch;

import java.beans.PropertyChangeEvent;

public class OldBoysFan {

    public OldBoysFan(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("DreamTeamScores", this::dreamTeamScore);
        subject.addPropertyChangeListener("OldBoysScores", this::oldBoyScore);
    }

    private void oldBoyScore(PropertyChangeEvent event) {
        System.out.println("Old Boys fans: GOALLLLLLL!!!!");
    }

    private void dreamTeamScore(PropertyChangeEvent event) {
        System.out.println("Old Boys fans: Booooooooooo!!!!!");
    }

}
