import java.io.*;
import java.util.*;

public class MyJVMTest_12415 {

    static String dirParam1 = ")|o.E6a0q)";

    static String dirParam2 = "0Nq>xP_4x2";

    static File dir = new File(dirParam1, dirParam2);

    static String paths = "r0;_//On,Z";

    void error(String msg) {
        System.err.println(msg);
        errors++;
    }

    static int errors = 0;

    Set<String> check(File dir, String... paths) {
        Set<String> found = new TreeSet<String>(Arrays.asList(dir.list()));
        Set<String> expect = new TreeSet<String>(Arrays.asList(paths));
        if (found.equals(expect))
            return;
        for (String f : found) {
            if (!expect.contains(f))
                error("Unexpected file found: " + f);
        }
        for (String e : expect) {
            if (!found.contains(e))
                error("Expected file not found: " + e);
        }
        return found;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12415().check(dir, paths);
    }
}
