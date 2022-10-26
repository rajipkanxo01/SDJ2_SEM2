package filterList;

public class FirstNameFilter implements Strategy {
    private String firstName;

    public FirstNameFilter(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean filter(Person p) {
        return p.getFirstname().equals(firstName);
    }
}
