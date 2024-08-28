import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_10737 {

    static String s = ")WWp^?Bf*3";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = false;

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10737().zeroCasesWithDefault(s, stringSet, expected));
    }
}
