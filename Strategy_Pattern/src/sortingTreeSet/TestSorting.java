package sortingTreeSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class TestSorting {
    public static void main(String[] args) {
        Person p1 = new Person("Rajib", "Paudyal", 20);
        Person p2 = new Person("Suhani", "Pandey", 24);
        Person p3 = new Person("Pramesh", "Shrestha", 16);
        
        List<Person> list = new ArrayList<>(Arrays.asList(p1, p2, p3));

        TreeSet<Person> ts = new TreeSet<>(new LastnameComparator());
        ts.addAll(list);

        System.out.println("\nSorting By Last Name: \n" + ts);

        TreeSet<Person> treeSet = new TreeSet<>(new AgeComparator());
        treeSet.addAll(list);

        System.out.println("\nSorting By First Name: \n" + treeSet);
        System.out.println();

    }
}
