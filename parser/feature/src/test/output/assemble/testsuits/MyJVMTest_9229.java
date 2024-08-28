import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_9229 {

    static String s = "9CAJOq'`n|";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = false;

    int oneCaseWithDefault(String s, Set<String> stringSet, boolean expected) {
        int failures = 2;
        boolean addResult;
        ;
        switch(s) {
            case "foo":
                failures = 0;
                addResult = stringSet.add(s);
                if (addResult != expected) {
                    failures++;
                    System.err.println("oneCaseNoDefault: Expectedly got add result of " + addResult + " on string " + s);
                }
                break;
            default:
                break;
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9229().oneCaseWithDefault(s, stringSet, expected));
    }
}
