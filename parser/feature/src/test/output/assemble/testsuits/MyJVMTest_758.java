import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_758 {

    static String s = "HLo@0Ed)[D";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = true;

    int oneCaseDefaultBreakOnly(String s, Set<String> stringSet, boolean expected) {
        int failures = 1;
        switch(s) {
            default:
                break;
        }
        failures = 0;
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_758().oneCaseDefaultBreakOnly(s, stringSet, expected));
    }
}
