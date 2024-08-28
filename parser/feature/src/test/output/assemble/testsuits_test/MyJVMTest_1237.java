import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;

public class MyJVMTest_1237 {

    static String expected = "k_bSR\\XA ;";

    static String actual = " mx|I7Z-W`";

    int checkForFailure(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.err.printf("ERROR: Expected ''%s'';%ngot             ''%s''.\n", expected, actual);
            return 1;
        } else
            return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1237().checkForFailure(expected, actual));
    }
}
