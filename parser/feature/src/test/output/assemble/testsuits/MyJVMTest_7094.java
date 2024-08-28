import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_7094 {

    static String s = "w,\"3/CM!hX";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = false;

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
        System.out.println(new MyJVMTest_7094().oneCaseBreakOnly(s, stringSet, expected));
    }
}
