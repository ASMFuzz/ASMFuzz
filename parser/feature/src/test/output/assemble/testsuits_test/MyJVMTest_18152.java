import java.io.IOException;
import java.util.Locale;

public class MyJVMTest_18152 {

    static String localeParam1 = "^tE0.aqX1A";

    static Locale locale = new Locale(localeParam1);

    static String[] writerSpiNames = { "DummyWriterPluginSpi" };

    static String[] formatNames = { "test_5076692", "TEST_5076692" };

    static String[] entensions = { "test_5076692" };

    static String[] mimeType = { "image/test_5076692" };

    String getDescription(Locale locale) {
        return "Standard Dummy Image Reader";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18152().getDescription(locale));
    }
}
