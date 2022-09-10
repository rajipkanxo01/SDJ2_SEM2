package soccerMatch;

import java.beans.PropertyChangeEvent;

public class DreamTeamFan {

    public DreamTeamFan(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("DreamTeamScores", this::dreamTeamScore);
        subject.addPropertyChangeListener("OldBoysScores", this::oldBoyScore);
    }

    private void oldBoyScore(PropertyChangeEvent event) {
        System.out.println("Dream team fans: Booooooooooo!!!!!");

    }

    private void dreamTeamScore(PropertyChangeEvent event) {
        System.out.println("Dream team fans: GOALLLLLLL!!!! ");

    }

}
