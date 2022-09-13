package soccerMatch;

import java.beans.PropertyChangeEvent;

public class ScoreBoard {

    public ScoreBoard(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("DreamTeamScores", this::updateScoreDreamTeam);
        subject.addPropertyChangeListener("OldBoysScores", this::updateScoreOldBoys);
    }

    private void updateScoreDreamTeam(PropertyChangeEvent event) {
        System.out.println(" Dream Team Goal: " + event.getNewValue());
    }

    private void updateScoreOldBoys(PropertyChangeEvent event) {
        System.out.println(" Old Boys Goal: " + event.getNewValue());
    }


}

