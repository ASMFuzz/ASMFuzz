import java.text.*;
import java.util.*;

public class MyJVMTest_16842 {

    static String f1Param1 = ".[t;PcZ_NL";

    static MessageFormat f1 = new MessageFormat(f1Param1);

    static String f2Param1 = "M.()V|`z 1";

    static String f2Param2Param1 = "Y>Y=pw}Rgq";

    static String f2Param2Param2 = ":i62$-P{$Z";

    static Locale f2Param2 = new Locale(f2Param2Param1, f2Param2Param2);

    static MessageFormat f2 = new MessageFormat(f2Param1, f2Param2);

    static boolean expected = false;

    boolean check(MessageFormat f1, MessageFormat f2, boolean expected) {
        boolean got = f1.equals(f2);
        if (got != expected) {
            throw new RuntimeException("Test failed for MessageFormat.equals(). Got: " + got + ", Expected: " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16842().check(f1, f2, expected);
    }
}
