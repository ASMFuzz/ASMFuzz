import java.util.*;

public class MyJVMTest_14882 {

    static String str = "wJV?#dC7`:";

    String testFromStringError(String str) {
        try {
            UUID test = UUID.fromString(str);
            throw new RuntimeException("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14882().testFromStringError(str);
    }
}
