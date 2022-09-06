package phone;

public class Phone {
    private PhoneState currentState =
            new SoundState();

    private int currentVolume;

    public int getVolume() {
        return currentVolume;
    }

    public void setState(PhoneState state) {
        this.currentState = state;
    }

    public void receiveMessage(String txt) {
        currentState.onReceiveMessage(txt, this);
    }

    public void receiveCall() {
        currentState.onReceiveCall(this);
    }

    public void volumeUpButton() {
        currentState.onVolumeButtonUp(this);
    }

    public void volumeDownButton() {
        currentState.onVolumeButtonDown(this);
    }

    // or use setState
    public void goToSilentState() {
        currentState = new SilentState();
    }

    void turnVolumeUp() {
        currentVolume++;
    }

    public void turnVolumeDown() {
        currentVolume--;
    }

    public void playRingTone() {
        System.out.println("Ringeling Ringeling");
    }

    public void vibrate() {
        System.out.println("Brrrrr!");
    }

    public void beepBeep() {
        System.out.println("Beep Beep!");
    }

    public void lightUpScreen () {
        System.out.println("Light Up Screen");
    }
}
