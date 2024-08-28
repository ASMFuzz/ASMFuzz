import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_16613 {

    static String s = "@'Iq7e'q}-";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = true;

    int oneCaseBreakOnly(String s, Set<String> stringSet, boolean expected) {
        int failures = 1;
        switch(s) {
            case "foo":
                break;
        }
        failures = 0;
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16613().oneCaseBreakOnly(s, stringSet, expected));
    }
}
