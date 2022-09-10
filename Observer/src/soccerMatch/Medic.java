package soccerMatch;

import java.beans.PropertyChangeEvent;

public class Medic {

    public Medic (PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("DreamTeamTackles" ,this::comesToHelp);
        subject.addPropertyChangeListener("OldBoysTackles" ,this::comesToHelp);
    }

    private void comesToHelp(PropertyChangeEvent event) {
        System.out.println("Medic comes to help");
    }
}
