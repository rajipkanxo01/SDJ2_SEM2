package filterList;

public class AgeFilter implements Strategy {
    private int maxAge;

    public AgeFilter(int maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public boolean filter(Person p) {
        return p.getAge() < maxAge;
    }
}
