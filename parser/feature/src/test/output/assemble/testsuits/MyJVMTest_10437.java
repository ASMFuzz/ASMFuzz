import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;

public class MyJVMTest_10437 {

    static String expected = "$+mcRo_2=%";

    static String actual = "_'y+S.%q#X";

    int checkForFailure(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.err.printf("ERROR: Expected ''%s'';%ngot             ''%s''.\n", expected, actual);
            return 1;
        } else
            return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10437().checkForFailure(expected, actual));
    }
}
