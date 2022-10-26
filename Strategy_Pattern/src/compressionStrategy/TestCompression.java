package compressionStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCompression {
    public static void main(String[] args) {
        Compressor compressor = new Compressor();
        compressor.setMethod(new ZipCompression());

        List<String> list = new ArrayList<>(Arrays.asList("Panguu", "Banguu", "Daiiii"));

        compressor.compress(list);
    }
}
