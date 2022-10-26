package filterList;

import java.util.ArrayList;

public interface ListADT {
    void add(Person s);

    void add(int idx, Person s);

    void set(int idx, Person s);

    Person get(int idx);

    Person remove(int idx);

    int size();

    boolean isEmpty();

    ArrayList<Person> getFiltered();
}
