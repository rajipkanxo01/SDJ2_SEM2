package DataRepresentation;

import java.beans.PropertyChangeEvent;

public class BarGraph {
    private int red;
    private int green;
    private int yellow;

    public BarGraph(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener("RedChange", this::reactToRed);
        subject.addPropertyChangeListener("GreenChange", this::reactToGreen);
        subject.addPropertyChangeListener("YellowChange", this::reactToYellow);
    }

    private void reactToYellow(PropertyChangeEvent event) {
        yellow = (int) event.getNewValue();
    }

    public int getYellow() {
        return yellow;
    }

    private void reactToGreen(PropertyChangeEvent event) {
        green = (int) event.getNewValue();
    }

    public int getGreen() {
        return green;
    }


    public void reactToRed(PropertyChangeEvent event) {
        red = (int) event.getNewValue();
    }

    public int getRed() {
        return red;
    }


}
