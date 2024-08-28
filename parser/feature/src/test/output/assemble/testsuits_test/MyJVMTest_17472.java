import java.text.*;
import java.util.*;

public class MyJVMTest_17472 {

    static String dfs1Param1Param1 = "IFaixnS7Q7";

    static Locale dfs1Param1 = new Locale(dfs1Param1Param1);

    static DateFormatSymbols dfs1 = new DateFormatSymbols(dfs1Param1);

    static String dfs2Param1Param1 = "EJKDbRy^.C";

    static Locale dfs2Param1 = new Locale(dfs2Param1Param1);

    static DateFormatSymbols dfs2 = new DateFormatSymbols(dfs2Param1);

    static boolean expected = true;

    boolean check(DateFormatSymbols dfs1, DateFormatSymbols dfs2, boolean expected) {
        boolean got = dfs1.equals(dfs2);
        if (got != expected) {
            throw new RuntimeException("Test failed for DateFormatSymbols.equals(). Got: " + got + ", Expected: " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17472().check(dfs1, dfs2, expected);
    }
}
