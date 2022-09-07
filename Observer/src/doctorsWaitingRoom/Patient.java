package doctorsWaitingRoom;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener {
    private WaitingRoom waitingRoom;
    private int ticket;

    public Patient(int ticket, WaitingRoom waitingRoom) {
        this.ticket = ticket;
        this.waitingRoom = waitingRoom;
        System.out.println("Patient " + ticket + " enters waiting room");
        waitingRoom.addPropertyChangeListener("Count Changed", this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        int currentValue = (int) evt.getNewValue();
        System.out.println("Patient  " + ticket + " looks up");
        if (currentValue == ticket) {
            waitingRoom.removePropertyChangeListener("Count Changed", this);
            System.out.println("Patient " + ticket + " goes to doctor room ");

        } else {
            System.out.println("Patient " + ticket + " goes back to looking at phone");
        }
    }
}
