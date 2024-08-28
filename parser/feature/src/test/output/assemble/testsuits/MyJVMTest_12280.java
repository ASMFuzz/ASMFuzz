import javax.imageio.metadata.IIOMetadata;

public class MyJVMTest_12280 {

    static String nativeMetadataFormatName = "simp_metadata_1.0";

    static int width = 1049920703, height = -945645961;

    void reset() {
        throw new IllegalStateException("read only metadata");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12280().reset();
    }
}
