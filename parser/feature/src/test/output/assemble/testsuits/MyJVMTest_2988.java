import java.io.*;
import java.text.*;
import java.util.Locale;

public class MyJVMTest_2988 {

    void testConstructor() {
        boolean npe = false;
        try {
            CollationKeyTestImpl cltNull = new CollationKeyTestImpl(null);
        } catch (NullPointerException npException) {
            npe = true;
        }
        if (!npe) {
            throw new RuntimeException("Failed: CollationKey Constructor with null source" + " didn't throw NPE!");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2988().testConstructor();
    }
}
