package soccerMatch;

import java.beans.PropertyChangeEvent;

public class ScoreBoard {

    public ScoreBoard(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("DreamTeamScores", this::updateScore);
        subject.addPropertyChangeListener("OldBoysScores", this::updateScore);
    }

    private void updateScore(PropertyChangeEvent event) {
        System.out.println(" Dream Team Goal: " + event.getNewValue());
    }


}

