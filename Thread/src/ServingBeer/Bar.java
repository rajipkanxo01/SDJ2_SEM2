package ServingBeer;

import java.util.ArrayList;

public class Bar {
    ArrayList<Beer> beers;
    int size;


    public Bar(int size) {
        beers = new ArrayList<>();
        this.size = size;
    }

    public void placeBeer(Beer b) {
        if (beers.size() < size) {
            beers.add(b);
            System.out.println("Beer is added.");
        } else {
            System.out.println("Can't add more beers");
        }
    }

    public void takeBeer() {
        if (beers.size() != 0) {
            beers.remove(0);
        }
    }


}
