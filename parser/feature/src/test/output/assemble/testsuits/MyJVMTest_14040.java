import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;
import javax.management.relation.*;

public class MyJVMTest_14040 {

    static String what = "I&j9*6_&B:";

    static boolean cond = true;

    static int failures = 0;

    String check(String what, boolean cond) {
        if (cond)
            System.out.println("OK: " + what);
        else {
            System.out.println("FAILED: " + what);
            failures++;
        }
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14040().check(what, cond);
    }
}
