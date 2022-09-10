package soccerMatch;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject {

    private String team0 = "Dream Team";
    private String team1 = "Old Boys";
    private int dreamTeamScore;
    private int oldBoysScore;
    private int dreamTeamFoul;
    private int oldBoysFoul;

    private PropertyChangeSupport matchSupport = new PropertyChangeSupport(this);

    public void startMatch() {
        System.out.println("Match starting \n\n");
        Random random = new Random();
        for (int i = 0; i < 90; i++) {

            int rand = random.nextInt(100);
            int whichTeam = random.nextInt(2);

            if (rand < 8) {
                // score goal
                scoreGoal(whichTeam);
            } else if (rand < 12) {
                // penalty
                roughTackle(whichTeam);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println("\n\nMatch ended");
        System.out.println("Dream Team Goal: " + dreamTeamScore + " && Old Boys Goal: " + oldBoysScore);

        if (dreamTeamScore > oldBoysScore) {
            System.out.println("Dream Team Wins!!!");
        } else {
            System.out.println("Old Boys Wins");
        }

    }

    private void roughTackle(int whichTeam) {
        if (whichTeam == 0) {
            int dreamTeamPreviousFoul = dreamTeamFoul;
            dreamTeamFoul++;
            System.out.println();
            System.out.println("Dream team rough tackle");
            matchSupport.firePropertyChange("DreamTeamTackles", dreamTeamPreviousFoul, dreamTeamFoul);
        } else {
            int oldBoysPreviousFoul = oldBoysFoul;
            oldBoysFoul++;
            System.out.println();
            System.out.println("Old Boys rough tackle");
            matchSupport.firePropertyChange("OldBoysTackles", oldBoysPreviousFoul, oldBoysFoul);
        }
    }

    private void scoreGoal(int whichTeam) {
        if (whichTeam == 0) {
            int dreamTeamPreviousScore = dreamTeamScore;
            dreamTeamScore++;
            System.out.println();
            System.out.println("Dream Team Scored");
            matchSupport.firePropertyChange("DreamTeamScores", dreamTeamPreviousScore, dreamTeamScore);
        } else {
            int oldBoysPreviousScore = oldBoysScore;
            oldBoysScore++;
            System.out.println();
            System.out.println("Old Boys Scored.");
            matchSupport.firePropertyChange("OldBoysScores", oldBoysPreviousScore, oldBoysScore);
        }
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        matchSupport.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        matchSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        matchSupport.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        matchSupport.removePropertyChangeListener(listener);
    }
}