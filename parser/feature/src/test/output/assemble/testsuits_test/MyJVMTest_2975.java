import javax.imageio.metadata.IIOMetadata;

public class MyJVMTest_2975 {

    static String nativeMetadataFormatName = "simp_metadata_1.0";

    static int width = 407131194, height = -1256803244;

    void reset() {
        throw new IllegalStateException("read only metadata");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2975().reset();
    }
}
