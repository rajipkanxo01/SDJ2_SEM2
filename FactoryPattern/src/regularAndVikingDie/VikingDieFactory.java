package regularAndVikingDie;

public class VikingDieFactory extends Factory {
    @Override
    public Die startDie() {
        return new VikingDie();
    }
}
