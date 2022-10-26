package compressionStrategy;

public class ZipCompression implements CompressionMethod {

    @Override
    public String compress(String filename) {
        System.out.println("Compressing " + filename  + " to zip");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Compressed to: " + filename + ".zip \n";
    }
}
