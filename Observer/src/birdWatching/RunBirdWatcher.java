package birdWatching;

public class RunBirdWatcher {
    public static void main(String[] args) throws InterruptedException {
        Bird bird = new Bird();
        BirdWatcher birdWatcher1 = new BirdWatcher(bird);
        BlindWatcher blindWatcher = new BlindWatcher(bird);

        bird.start();
    }
}
