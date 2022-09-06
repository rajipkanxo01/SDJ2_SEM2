package bearAndMan;

public class ManPokingBear {
    public static void main(String[] args) {

        Thread bearThread = new Thread(new Bear());
        Thread manThread = new Thread(new Man(bearThread));

        bearThread.start();
        manThread.start();
    }
}
