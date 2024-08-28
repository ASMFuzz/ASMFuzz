import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;
import javax.management.relation.*;

public class MyJVMTest_4649 {

    static String what = "h[(<O_;0V-";

    static boolean cond = false;

    static int failures = 1;

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
        new MyJVMTest_4649().check(what, cond);
    }
}
