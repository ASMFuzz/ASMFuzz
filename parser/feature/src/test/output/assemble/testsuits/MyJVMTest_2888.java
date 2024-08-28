import javax.imageio.spi.IIOServiceProvider;
import javax.imageio.spi.ImageInputStreamSpi;

public class MyJVMTest_2888 {

    static String spiParam1 = "A&C$V$@pA*";

    static String spiParam2 = "9X*#{t&_r.";

    static Class<?> spiParam3 = null;

    static IIOServiceProvider spi = new ImageInputStreamSpi(spiParam1, spiParam2, spiParam3);

    String check(IIOServiceProvider spi) {
        String version = spi.getVersion();
        if (!version.equals("1.0")) {
            throw new RuntimeException("Provider " + spi.getClass().getName() + " has version " + version + "!");
        }
        return version;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2888().check(spi);
    }
}
