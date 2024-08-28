import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_15498 {

    static String s = "~NT)?`U,z4";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = true;

    int zeroCasesWithDefault(String s, Set<String> stringSet, boolean expected) {
        int failures = 2;
        boolean addResult;
        switch(s) {
            default:
                failures = 0;
                addResult = stringSet.add(s);
                if (addResult != expected) {
                    failures++;
                    System.err.println("zeroCaseWithDefault: Expectedly got add result of " + addResult + " on string " + s);
                }
        }
        return failures;
    }

    int zeroCasesWithDefaultBreak(String s, Set<String> stringSet, boolean expected) {
        int failures = 2;
        boolean addResult;
        switch(s) {
            default:
                failures = zeroCasesWithDefault(s, stringSet, expected);
                break;
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15498().zeroCasesWithDefaultBreak(s, stringSet, expected));
    }
}
