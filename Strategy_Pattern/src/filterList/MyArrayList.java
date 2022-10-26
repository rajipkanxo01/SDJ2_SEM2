package filterList;

import java.util.ArrayList;

public class MyArrayList implements ListADT {
    private ArrayList<Person> implementation = new ArrayList();
    private Strategy filter;

    public MyArrayList(Strategy filter) {
        this.filter = filter;
    }

    @Override
    public void add(Person s) {
        implementation.add(s);
    }

    @Override
    public void add(int idx, Person s) {
        implementation.add(idx, s);
    }

    @Override
    public void set(int idx, Person s) {
        implementation.set(idx, s);
    }

    @Override
    public Person get(int idx) {
        return implementation.get(idx);
    }

    @Override
    public Person remove(int idx) {
        return implementation.remove(idx);
    }

    @Override
    public boolean isEmpty() {
        return implementation.isEmpty();
    }

    @Override
    public ArrayList<Person> getFiltered() {
        ArrayList<Person> filteredList = new ArrayList<>();
        for (Person value : implementation) {
            if (filter.filter(value)) {
                filteredList.add(value);
            }
        }
        return filteredList;
    }

    @Override
    public int size() {
        return implementation.size();
    }


}
