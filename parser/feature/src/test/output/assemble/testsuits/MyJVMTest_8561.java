import java.io.IOException;
import java.util.Locale;

public class MyJVMTest_8561 {

    static String localeParam1 = "h%{ !p\\]z_";

    static Locale locale = new Locale(localeParam1);

    static String[] writerSpiNames = { "DummyWriterPluginSpi" };

    static String[] formatNames = { "test_5076692", "TEST_5076692" };

    static String[] entensions = { "test_5076692" };

    static String[] mimeType = { "image/test_5076692" };

    String getDescription(Locale locale) {
        return "Standard Dummy Image Reader";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8561().getDescription(locale));
    }
}
