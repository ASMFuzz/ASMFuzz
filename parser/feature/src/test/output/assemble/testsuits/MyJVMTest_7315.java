import java.text.*;
import java.util.*;

public class MyJVMTest_7315 {

    static String f1Param1 = "/9M^l6b]F3";

    static MessageFormat f1 = new MessageFormat(f1Param1);

    static String f2Param1 = "\\S~*lmkK+0";

    static MessageFormat f2 = new MessageFormat(f2Param1);

    static boolean expected = true;

    boolean check(MessageFormat f1, MessageFormat f2, boolean expected) {
        boolean got = f1.equals(f2);
        if (got != expected) {
            throw new RuntimeException("Test failed for MessageFormat.equals(). Got: " + got + ", Expected: " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7315().check(f1, f2, expected);
    }
}
