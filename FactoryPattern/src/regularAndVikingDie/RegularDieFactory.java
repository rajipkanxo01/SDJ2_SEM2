package regularAndVikingDie;

public class RegularDieFactory extends Factory {
    @Override
    public Die startDie() {
        return new RegularDie();
    }
}
