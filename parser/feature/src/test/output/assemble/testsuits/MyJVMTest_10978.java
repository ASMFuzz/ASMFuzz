import java.util.*;
import java.text.*;

public class MyJVMTest_10978 {

    void currencyTest() throws RuntimeException {
        final String strExpected = "\u0E3F\u0E51\u0E52\u002C\u0E53\u0E54\u0E55\u002C\u0E56\u0E57\u0E58\u002E\u0E52\u0E53";
        final double value = 12345678.234;
        Locale locTH = new Locale("th", "TH", "TH");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locTH);
        String str = nf.format(value);
        if (!strExpected.equals(str)) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10978().currencyTest();
    }
}
