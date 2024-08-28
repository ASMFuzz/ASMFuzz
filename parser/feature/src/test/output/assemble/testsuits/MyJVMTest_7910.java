import java.text.*;
import java.util.*;

public class MyJVMTest_7910 {

    static String dfs1Param1Param1 = "9Tae'PKl:(";

    static Locale dfs1Param1 = new Locale(dfs1Param1Param1);

    static DateFormatSymbols dfs1 = new DateFormatSymbols(dfs1Param1);

    static DateFormatSymbols dfs2 = new DateFormatSymbols();

    static boolean expected = false;

    boolean check(DateFormatSymbols dfs1, DateFormatSymbols dfs2, boolean expected) {
        boolean got = dfs1.equals(dfs2);
        if (got != expected) {
            throw new RuntimeException("Test failed for DateFormatSymbols.equals(). Got: " + got + ", Expected: " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7910().check(dfs1, dfs2, expected);
    }
}
