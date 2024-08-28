import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_17947 {

    static String s = "HhZTZ\\Y{%e";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = false;

    int oneCaseNoDefault(String s, Set<String> stringSet, boolean expected) {
        int failures = 2;
        boolean addResult;
        switch(s) {
            case "foo":
                failures = 0;
                addResult = stringSet.add(s);
                if (addResult != expected) {
                    failures++;
                    System.err.println("oneCaseNoDefault: Unexpectedly got add result of " + addResult + " on string " + s);
                }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17947().oneCaseNoDefault(s, stringSet, expected));
    }
}
