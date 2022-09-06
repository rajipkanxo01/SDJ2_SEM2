package counter;

public class Counter  {
    private int count;

    public Counter() {
        count = 0;
    }

    public void update() {

        count++;
    }

    public int getCount() {
        return count;
    }

}
