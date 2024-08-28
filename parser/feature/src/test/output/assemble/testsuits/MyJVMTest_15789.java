import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_15789 {

    static String expected = "kPM&}b~<Og";

    static String actual = "yUX=3\"Y*V2";

    int check(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.err.printf("ERROR: Expected ''%s'';%ngot             ''%s''.\n", expected, actual);
            return 1;
        } else
            return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15789().check(expected, actual));
    }
}
