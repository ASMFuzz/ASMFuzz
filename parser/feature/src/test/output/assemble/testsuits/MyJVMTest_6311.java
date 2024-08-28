import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_6311 {

    static String expected = "{tdZwWF]4b";

    static String actual = "vl|B1P% H4";

    int check(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.err.printf("ERROR: Expected ''%s'';%ngot             ''%s''.\n", expected, actual);
            return 1;
        } else
            return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6311().check(expected, actual));
    }
}
