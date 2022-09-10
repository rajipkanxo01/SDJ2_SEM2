package soccerMatch;

import java.beans.PropertyChangeEvent;

public class AngryCoach {

    public AngryCoach(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("DreamTeamScores", this::reactToTeamGoal);
        subject.addPropertyChangeListener("OldBoysScores", this::reactToBoysGoal);
        subject.addPropertyChangeListener("OldBoysTackles", this::reactToBoysTackle);
        subject.addPropertyChangeListener("DreamTeamTackles", this::reactToTeamTackle);
    }

    private void reactToTeamTackle(PropertyChangeEvent event) {
        System.out.println("Old Boys Coach:  This is clearly foul");
    }

    private void reactToBoysTackle(PropertyChangeEvent event) {
        System.out.println("Dream Team Coach: This is clearly foul");
    }

    private void reactToBoysGoal(PropertyChangeEvent event) {
        System.out.println("Old Boys Coach: Yeahhhhhhhhh!!!!");
    }

    private void reactToTeamGoal(PropertyChangeEvent event) {
        System.out.println("Dream Team Coach: Yeahhhhhhhhh!!!!!! ");
    }
}
