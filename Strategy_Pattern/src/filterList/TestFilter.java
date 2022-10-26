package filterList;

public class TestFilter {
    public static void main(String[] args) {
        MyArrayList ageList = new MyArrayList(new AgeFilter(20));
        ageList.add(new Person("Rajib", "Paudyal", 21));
        ageList.add(new Person("Suhani", "Pandey", 20));
        ageList.add(new Person("Pramesh", "Shrestha", 16));
        System.out.println(ageList.getFiltered());


    }
}
